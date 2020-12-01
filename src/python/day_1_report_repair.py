#!/usr/bin/env python3

def part1(input_list):
    expenses = sorted(input_list)

    a = 0
    b = len(expenses) - 1

    while a < b:
        val1 = expenses[a]
        val2 = expenses[b]
        sum = val1 + val2
        if sum == 2020:
            print("input = {}, val1 = {}, val2 = {}, product = {}".format(input_list, val1, val2, val1 * val2))
            return
        elif sum < 2020:
            # sum too low - move 1st pointer to next highest
            a += 1
        else:
            # only possibility here is sum > 2020, so sum is too high - move 2nd pointer to next lowest
            b -= 1


if __name__ == '__main__':
    file = open('../main/resources/input.txt', mode="r")
    ints = []
    for s in file:
        ints.append(int(s))

    part1(ints)

    # part1([1721, 979, 366, 299, 675, 1456])
    # part1([10, 20, 1009, 4000, 3000, 1011])
