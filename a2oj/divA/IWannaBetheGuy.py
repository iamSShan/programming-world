# http://codeforces.com/problemset/problem/469/A

n = int(input())

x = list(map(int, input().split()))
y = list(map(int, input().split()))
px = x[0]
py = y[0]

x = x[1:]
y = y[1:]

if px == 0 and py == 0:
	flag = False

else:
	f = x+y
	f = list(set(f))

	f.sort()

	# print(f)

	flag = True
	if len(f) < n:
		flag = False

	else:
		count = 0
		# for i in range(1, n+1):
		# 	if i != f[count]:
		# 		flag = False
		# 		break
		# 	count+=1
		for i in range(0, n):
			if (i+1) - i != 1:
				flag = False
				break

if(flag == True):
	print("I become the guy.")
else:
	print("Oh, my keyboard!")