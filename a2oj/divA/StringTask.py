# Problem: http://codeforces.com/problemset/problem/118/A

# Input String
s = input()

out = []
# Now iterate in the list
for ch in s:
	if ch in ["A", "O", "Y", "E", "U", "I"] or ch in ["a", "o", "y", "e", "u", "i"]:
		pass
	else:
		out.append(".")
		# If uppercase consonant
		if ord(ch) >= 65 and ord(ch) <= 90:
			# Convert it to lowercase
			out.append(chr(ord(ch)+ 32))
		# If lowercase consonant
		else:
			out.append(ch)

print("".join(out))
