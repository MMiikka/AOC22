from heapq import heappop, heappush, heapify

with open('input.txt') as f:
    lines = f.readlines()
input = []
for i in range(len(lines)):
  input.append(lines[i].replace('\n',''))
  if input[i] != '':
    input[i] = int(input[i],base=10)
  
  sums = []

  high = 0
  tmp = 0
for i in range(len(input)):
    if input[i] != '':
      tmp += input[i]
    else:
      sums.append(tmp)
      if tmp > high:
        high = tmp
      tmp = 0

sums.sort(reverse=True)

print(sums[0] + sums[1] + sums[2])


