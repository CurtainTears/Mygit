#calLoan.py
#coding=utf-8
def cal_loan(a,p,y):
    m=a*(p/12)*(1+p/12)**(12*y)/((1+p/12)**(12*y)-1)
    return m
A,Y=input("Enter total LOAN and YEAR separated by a comma:")
CG =raw_input("Enter loan Mode:")
P=0
if CG in['c','C']:               #????
    if Y>0 and Y<=1:
        P=0.06
    elif Y>1 and Y<=3:
        P=0.0615
    elif Y>3 and Y<=5:
        P= 0.064
    elif Y>5:
        P=0.0655
    else:
        print "Input is wrong!"
elif CG in['g','G']:
    if Y>0 and Y<=5:
        P=0.04
    elif Y>5:
        P=0.0450
    else:
        print "Input is wrong!"
else:
    print "Input is wrong!"
M=cal_loan(A,P,Y)
print "Monthly Pay:%d" %M