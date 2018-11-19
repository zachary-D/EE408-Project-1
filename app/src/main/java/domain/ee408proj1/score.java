package domain.ee408proj1;

public class score
{
    score(String _name, int _correct, int _total)
    {
        name = _name;
        correct = _correct;
        total = _total;
    }

    String name;
    int correct;
    int total;
}