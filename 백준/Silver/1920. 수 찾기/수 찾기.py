
def search(list,target):
    left = 0 
    right = len(list) - 1

    while ( left < right ):
        mid = (left+right)//2
        if list[mid] < target:
            left = mid + 1
        else:
            right = mid 

    return 1 if list[(left+right)//2] == target else 0

N = int(input())
nums = sorted(list(map(int,input().split())))
M = int(input())
finds = list(map(int,input().split()))

for find in finds:
    print(search(nums,find))