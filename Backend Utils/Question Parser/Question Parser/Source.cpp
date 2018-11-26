#include <iostream>
#include <fstream>
#include <string>

using namespace std;

string fileSource = "../questions.csv";
string fileOutput = "../questions.java";


struct question
{
	question() {}

	question(string prompt, string answer[4])
	{
		this->prompt = prompt;
		for(unsigned i = 0; i < 4; i++)
		{
			this->answer[i] = answer[i];
		}
	}

	question(string prompt, string ans1, string ans2, string ans3, string ans4)
	{
		this->prompt = prompt;
		answer[0] = ans1;
		answer[1] = ans2;
		answer[2] = ans3;
		answer[3] = ans4;

	}

	string prompt;
	string answer[4];
};

//Checks for single-quotes in the string and escapes them by doubling them up (i.e. ab'd -> ab''d)
void escapeQuote(string & line)
{
	for(unsigned i = 0; i < line.length(); i++)
	{
		if(line[i] == '\'')
		{
			line.insert(line.begin() + ++i, '\'');
		}
	}
}

question parseLine(string line)
{
	string segment;

	auto advance = [&segment, &line]()
	{
		segment = line.substr(0, line.find(','));
		line = line.substr(line.find(',')+1);
		return segment;
	};


	escapeQuote(line);

	question myQuestion;

	myQuestion.prompt = advance();
	
	for(unsigned i = 0; i < 4; i++)
	{
		myQuestion.answer[i] = advance();
	}

	return myQuestion;
}

//Returns a SQL command to add 'inp' to the question DB
string genSQLCommand(question inp)
{
	//'First question', 'correct', 'inc1', 'inc2', 'inc3')");";

	string command = "db.execSQL(\"insert into \" + TABLE_QU + \" values(null, '" + inp.prompt + "'";
	for(unsigned i = 0; i < 4; i++)
	{
		command += ", '" + inp.answer[i] + "'";
	}
	command += ")\");";

	return command;
}

int main(int argc, char * argv[])
{
	ifstream read;
	read.open(fileSource);

	ofstream write;
	write.open(fileOutput);

	//Discard the first line (the headers)
	{
		string tBuf;
		getline(read, tBuf);
	}
	do
	{
		string buf;
		getline(read, buf);
		string command = genSQLCommand(parseLine(buf));
		write << command << endl;
		cout << command << endl;

	} while(!read.eof());

	cout << endl << endl;
	cout << "Questions file \"" + fileSource + "\" processed and stored in \"" + fileOutput + "\"." << endl;
	cout << endl;
	cout << "Press <Enter> to quit." << endl;
	cin.get();
	return 0;
}