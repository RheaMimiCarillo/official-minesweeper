# Minesweeper

## The problem

Have you ever played Minesweeper? 
It is a cute little game which comes within a certain Operating System which name we cannont really remember.
Well, the **goal** of the game is to **find all** of the **mines** within an MxN field.
To help you, the game shows a number in a square which tells you **how many mines** there **are adjacent** to that square. 
For instance, suppose the following 4x4 field with 2 mines (which are represented by an * character):

```text
* . . .
. . . .
. * . .
. . . .
```

If we would represent the same field placing the hint numbers described above, we would end up with:

```text
* 1 0 0
2 2 1 0
1 * 1 0
1 1 1 0
```

As you may have already noticed, each square may have at most 8 adjacent squares (cardinal directions & diagonals).

## The input

The input will consist of an arbitrary number of fields.
The first line of each input contains two integers `n` and `m` (0 < n,m <= 100). N and m stand for the number of lines and columns of the field, respectfully.
The next n lines contain exactly m characters and represent the field.
Each safe square is represented by a "." character (without the quotes) and each mine square is represented by an "*" character, (also without the quotes).
The first field lines wehre n = m = 0 represents the end of input and should not be processed.

## The output

For each field, you must print the following message in the line alone:

```text
Field #x:
```

Where x stands for the number of the field (starting form 1). The next n lines should contain the field with the "." characters replaced by the number of adjacent mines to that square. There must be an empty line between field outputs.

## Sample input

```text
4 4  
* . . .
. . . .
. * . .
3 5
* * . . .
. . . . .
. * . . .
0 0
```

## Sample output

```text
Field #1:
*100
2210
1*10
1110

Field #2:
**100
33200
1*100
```
