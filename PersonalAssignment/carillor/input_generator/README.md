# Minefield Input Generator

In addition to the coded solutions specified in the assignment, the team should write an input
generating program using ChatGPT, Gemini, or some other AI, whose output can be used as input
to
test your solutions. Place this in a project of its own. You do not have to write unit tests
for this
program (but will write unit tests for your official solution). This program is where you might
ask yourselves (since you are the ones running it) how many rows and columns you want for a
minefield and what percentage of mines you would like. Use this program to build the robust
input file that you should use to test your **individual** and **official** team solutions. The
details of the input file contents are given below.

AI-generated readme follows:

A standalone Java utility that produces a robust `team_minesweeper_input.txt` for TCSS 360
Group Assignment 1.  
Generates at least 15 distinct Minesweeper fields—including all edge cases—and terminates with
`0 0`.

---

## Features

- **Edge cases**
    - `1×1` (mine and empty)
    - `1×100` / `100×1` (all-`*` and all-`.`)
    - `100×100` (all-`*` and all-`.`)
- **Non-square examples** (`3×5`, `7×2`, `4×6`)
- **Medium and large random fields**
- **Fixed seed** (2025) for reproducible output
- **Terminates** with the required `0 0` header

---

## Prerequisites

- Java 11 or later
- (Optional) Git for version control

---

## Project Structure

    .
    ├── src/
    │ └── main/generator/MinefieldGenerator.java
    └── README.md