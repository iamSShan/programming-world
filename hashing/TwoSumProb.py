"""
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

"""

n = int(input("Enter number of elements: "))
# First way to take elements input:
# lst
# for i in range(0, n):
#     ele = int(input())
 
#     lst.append(ele) # adding the element


# Second way for Python 3:
# Input list
nums =  list(map(int,input("\nEnter the numbers : ").strip().split()))[:n]
target = int(input("Enter target sum: "))

d = {}
out = []
for i in range(0, n):
	if target-nums[i] in d:
		out.append(d[target-nums[i]])
		out.append(i)
	else:
		d[nums[i]] = i

print(out)


