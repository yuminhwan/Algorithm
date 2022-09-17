import sys,itertools
input = sys.stdin.readline

N,M = map(int,input().split())
arr = [str(i+1) for i in range(N)]

for e in itertools.permutations(arr,M):
    print(" ".join(e))