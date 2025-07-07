# Minesweeper

## The problem

Have you ever played Minesweeper?
It is a cute little game which comes within a certain Operating System which name we cannot
really remember.
Well, the **goal** of the game is to **find all** the **mines** within an MxN field.
To help you, the game shows a number in a square which tells you **how many mines** there **are
adjacent** to that square.
For instance, suppose the following 4x4 field with 2 mines (which are represented by an *
character):

```text
* . . .
. . . .
. * . .
. . . .
```

If we represent the same field placing the hint numbers described above, we would end up
with:

```text
* 1 0 0
2 2 1 0
1 * 1 0
1 1 1 0
```

As you may have already noticed, each square may have at most 8 adjacent squares (cardinal
directions & diagonals).

## The input

The input consists of an arbitrary number of minefields.

The first line of each input contains two integers `n` and `m` (`0 < n,m <= 100`).
`n` and `m` stand for the **number of lines** and **columns** of the minefield, respectively.
The next `n` lines contain exactly `m` characters and represent the minefield.

Each "safe" square is represented by a '`.`' character (without the quotes) and each "mine"
square
is represented by an '`*`' character, (also without the quotes).

The first field lines where `n = m = 0` represents the **end of input** and should **not** be
processed.

## The output

For each field, you must print the following message in the line alone:

```text
Field #k:
```

Where 'k' stands for the number of the field (starting from 1).

The next `n` lines should contain the field with the '`.`' characters replaced by the number of
adjacent mines to that square.

There must be **an empty line between minefield outputs**.

## Sample input

```text
4 4  
* . . .
. . . .
. * . .
. . . .
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
