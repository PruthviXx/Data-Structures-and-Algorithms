def optimal(string : str) -> int:
    longestSubstring = -1
    start = 0 ; end = 0
    hashmap = {}
    count = 0
    finalSubString = ""
    tempString = ""

    while end < len(string):
        if((string[end]) in hashmap) and hashmap[string[end]] >= start:
            subLength = end - start
            if(longestSubstring < subLength):
                finalSubString = ""
                for i in range(start,end):
                    finalSubString+=string[i]
            
            longestSubstring = max(longestSubstring,subLength)
            start = hashmap[string[end]] + 1
            # print("working")

        hashmap[string[end]] = end
        end+=1

    print(finalSubString)
    return longestSubstring


def bruteForce(string : str) -> int:
    longestSubstring = -1

    for j in range(len(string)):
        count = 0
        onlyUnique = set()
        for i in range(j,len(string)):
            if(string[i]) in onlyUnique:
                break
            onlyUnique.add(string[i])
            count+=1
        longestSubstring = max(longestSubstring,count)

    return longestSubstring

string = "geeksforgeeks"
# string = "abcabcdefabc"
print(f"Longest substring length in {string} is {optimal(string)}")
