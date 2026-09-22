from math import factorial

A = (input('Введите число '))
B = (input('Введите из какой системы счисления число '))
C = (input('Введите в какую систему счисления '))

if B == 'Факт' and C == '10':
    A = A[::-1]
    ans = 0
    cnt = 1
    for i in A:
        ans += (int(i) * factorial(cnt))
        cnt += 1
    print(ans)

elif B == '10' and C == 'Фиб':
    arr = [1, 1]
    A = int(A)
    while arr[-1] < A:
        arr.append(arr[-1] + arr[-2])
    
    ans = ''
    
    arr = arr[::-1]
    arr = arr[1:]
    for i in arr:
        if A > i:
            A -= i
            ans += '1'
        else:
            ans += '0'
    print(ans)

elif B == '10' and C == '9C':
    b9 = ''
    a = int(A)
    while a != 0:
        b9 = b9 + str(a % 9)
        a //= 9
    
    ans = ''
    check = False
    arr = [int(i) for i in b9]
    for i in range(len(arr)):
        if arr[i] > (9/2):
            if check:
                ans = str(arr[i]+1-9) + ans
                check = True
            else:
                ans = str(arr[i]-9)+ ans
                check = True
        else:
            if check:
                ans = str(arr[i] + 1) + ans
                check = False
            else:
                ans = str(arr[i]) + ans
    print(ans)
    
elif B == '-10' and C == '10':
    a = str(A)[::-1]
    cnt = 0
    ans = 0
    for i in a:
        ans += int(i)*(-10)**cnt
        cnt += 1
    print(ans)