EE408-Project 1

Repo naming conventions:
	
	Commit messages should be fairly descriptive, but not too verbose.  'Fixed issue #13' (referring to github issues) is an acceptable commit message, provided the issue on github clearly documents the issue.
	
	Each person will work within their own branches, to prevent conflicts with multiple people committing to the same branches at once.
	
	Branches should be made off of master with the naming convention [USER]/[task-description], where 'USER' is your name, last name, username, etc. (doesn't matter as long as it is unique and consistant) and 'task-description' is a breif description of the task you're working on.  An example would be "zack/scoreboard".  Branches may be made off other branches, if the source branch is not ready to be merged into the master branch, and the branch being created requires features/code only present in the source branch.
	
	Once work on a branch is done it may be merged back into master if the following conditions are met:
		1) The code compiles successfully
		2) The changes must not break any other features
		3) The feature must be working (there's no sense in merging useless code into the master branch)
	
	