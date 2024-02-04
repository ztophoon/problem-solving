import sys
sys.setrecursionlimit(10**6)

def check(t) :
    if t == S :
        return True
    if len(t) == 1 :
        return False
    if t[-1] == 'A' : # 1번
        return check(t[:-1])
    if t[-1] == 'B' : # 2번
        t = t[:-1]
        return check(t[::-1])

S = input()
T = input()

if check(T) :
    print(1)
else :
    print(0)