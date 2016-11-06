#print absolute value of an integer
input_str=raw_input("what is the temperature?")
if input_str[-1] in['C','c']:
    f = 1.8*eval(input_str[0:-1])+32
    print "the converted tem is %dF" %f
elif input_str[-1] in['F','f']:
    c=(eval(input_str[0:-1])-32)/1.8
    print "%dC" %c
else:
    print "Input is wrong!"