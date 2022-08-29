import sys 
input = sys.stdin.readline


T = int(input())

for _ in range(T):
    _list = list(map(int,input().split()))
    _list.sort()
    print(_list[-3])

