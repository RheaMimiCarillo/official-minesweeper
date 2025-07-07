# Minesweeper

Group Assignment 1

    Due Monday by 11:59pm Points 75 Submitting a file upload File Types zip

Read through the problem specification below.

Problem specification: minesweeper.pdf (see project files)

The following information pertains to the problem.

    - all input is guaranteed to be well-formed
    - input must be **read in from the console/keyboard/System.in**
        - **for testing**, you can **place** your **input** **in** a **file** and **redirect that file** from the **command prompt** (as shown in class)
        - it is also ok to **look for a command line argument** that is the name of a file and open that for input in addition to reading from System.in (also as shown in class)
    - **output** must be **formatted precisely** as specified
        - this means you will **NOT prompt for input in the program**
    - **output** must be **printed to the console/monitor/System.out**

**Each team member** must provide an **individual solution** to the problem. 
The **team** should also provide an **'official' team solution**. 
The **official solution** should **conform** to the **documentation standards** posted here on Canvas. 
Make sure **each solution has** the **name of** the code **author** **at the top** of the source code in comments. 
The **official solution should be labeled** as such. 
These solutions can be produced in either Eclipse or IntelliJ, but **all team member solutions** **and** the **official solution** should use the **same IDE**.
**Each project** should be **named** with the **team member's last name** and **first initial of first name** (e.g. capault). 
The **official project** should **start with** the name **'official'**.

## Input generator program

In addition to the coded solutions specified above, the team should **write an input generating program** **using** ChatGPT, Gemini, or some other **AI**, whose **output** can be **used as input to test** your solutions. 
**Place this** in a project of its own. 
You **do not have to write unit tests for this** program (but will write unit tests for your official solution). 
This program is where you might **ask yourselves** (since you are the ones running it) **how many rows and columns you want** for a minefield and **what percentage of mines** you would like. 
Use this program to **build the robust input file** that you **should use to test** your **individual** and **official team solutions**. 
The details of the input file contents are given below.

## Official input and output files

Official input and output files for testing and comparison of results

    - minesweeper_input.txt (see project files)
	- minesweeper_output.txt (see project files)

## Tests

**Build unit tests** to test your official solution.
**Incorporate** the results from your **input generator into** your **unit tests**. 
Your tests should **cover all edge cases** (**minimums**, **maximums**) as well as some **general cases**. 
Recall that the input to the program will be well-formed so you are ***not* required to test for invalid data**. 
There should be individual **test methods for each case you test**. 
Be sure and **name** your **test methods** so they **describe the test**. 
These unit tests should be part of your official solution. 
Unit **test** any basic code in your official solution (e.g. your method where you **read in a minefield**, your method where **you produce hints**, and **any other important methods** you wrote). 
**Modular design** of your official solution **is critical** so you can easily **write unit tests for each** of the **tasks** your program performs.

## File redirection

Also **run your official solution from the console/command prompt using a file** that contains **robust test data for program**. 
The **name** of that file is **minesweeper_input.txt**. 
The contents of that file are given below.  
**Redirect this file** into the program **from the command line**. 
**Capture the output** by **redirecting from the command line** into a file named ***team_minesweeper_output.txt***. 
**GIANT NOTE: Do not run your initial program against the official input file (which is very large and contains many edge cases). Build simple input files for testing!**

## Readme.txt

Finally, **include a readme**.txt file as part of your submission **that lists all team member names**, **which IDE** you used, an **estimate** of **how much time it took** you to complete all deliverables, and **any shortcomings** your solution(s) have.

## Submission

There should be a **single submission per team**. **Choose someone to submit** that will make sure all required items are included in your submission and it is submitted on time. All contents should be **placed in a zip file named *assignment1Minesweeper***.

## Summary

To summarize what you will submit:

    - Place all items in a zip file named assignment1Minesweeper
        - readme.txt
            - has team member names
            - lists estimate of time it took to produce solution
            - lists any shortcomings/concerns with the solution
        - team member solutions/project (each should be in a properly labeled folder)
            - each of these solutions should run correctly
            - team member solutions should be tested against the official input - file above and produce the same output as the official output
            - include something in each team member project folder that makes clear that program runs correctly
            - NOTE: individual solutions must also read input from System.in and write output to System.out
            - NOTE 2: individual solutions do not require documentation or unit tests (but those are great if they are included :-)
        - official solution (which contains unit tests)  in its own folder
        - input generator solution -- place this in its own folder
        - team_minesweeper_output.txt (this is a capture of the output from running official solution against minesweeper_input.txt)
        - team_minesweeper_input.txt
            - NOTE: this file should have a LARGE number of test minefields (at least 15 to ensure edge cases are covered and you have a reasonable number of general cases)
            - It should include to two test cases given in the problem statement for minesweeper
            - It should include edge cases (e.g. 
				- 100x100 all mines, 
				- 100x100 no mines, 
				- 100x100 mixed mines, 
				- 1x100 cases, 
				- 100x1 cases, 
				- 1x1 cases, 
				- random size cases with different percentages of mines) - 
				- NOTE: It is ok to include some of the items from minesweeper_input.txt if you wish.

GET STARTED ON YOUR INDIVIDUAL SOLUTION ASAP!

## Rubric
Minesweeper Rubric

Total Points: 75 

### Individual solutions (30 pts)

- (10 pts) All three individual solutions included. 
- (10 pts) All follow specs of Minesweeper program. 
- (10 pts) All produce correct output for official input fiile. 

### Official solution (20 pts)
- (20 pts) Includes unit tests. Follows coding standards.

### Input generator program (10 pts)
- (10 pts) Follows coding standards.

### minesweeper_input and output (5 pts)
- (5 pts) text files included in zip

### Miscellaneous
- (10 pts) Covers anything not in criteria in the rest of the rubric.

## Miscellaneous Notes
The input to that looks like a numbers, dots, and asterisks.

- All input is guaranteed to be well-formed.
- Input MUST be read in from the console/keyboard/`System.in`.
    - For testing you can place your input in a file and redirect that file from the command
      prompt (as shown in class). By default, the program must read from `System.in`.
    - It is also OK to look for a command line argument that is the name of a file and open
      that
      input in addition to reading from `System.in` (also as shown in class).
- Output must be formatted **precisely** as specified.
    - This means you will NOT prompt for input. Do not ask the user to input any lines of data.
- Output must be printed to the console/monitor/`System.out`.

Each member must provide an individual solution to the problem. The team should also provide an 'official' team solution.
**The official solution should conform to the documentation standards posted on Canvas.**

1. Do individual solutions each.
2. As a team, decide what bits are going to be in the _official_ solution.
3. The official solution must all be written in the same IDE.
4. All team members must agree to use the same language, if using a language other than Java.
5. Formally document the official solution.
