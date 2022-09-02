import heapq,sys
input = lambda : sys.stdin.readline().rstrip()

heap = []

for _ in range(int(input())):
    x = int(input()) * -1 
    if x == 0:
        if heap:
            print(heapq.heappop(heap) * -1)
        else:
            print(0)
    else:
        heapq.heappush(heap, x)