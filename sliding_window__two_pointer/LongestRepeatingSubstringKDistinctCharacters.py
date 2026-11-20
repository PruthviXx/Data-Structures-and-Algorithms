# // "aadbabbacdce"
# // end pointer will move forward passively adding character into map also maintaining k distict values in map
# // whenever encounter length greater than k, move the start pointer until found the last occurrent of current characeter
# // compute the length at every step
class Solution:
    def optimal(self, s : str, k : int) -> int:
        longestSubstring = 0
        start = end = 0
        hash_map = {}

        while end < len(s):
            if len(hash_map) is k and s[end] not in hash_map:
                # adjust the window to last occured distinct character
                while start is not hash_map[s[start]]:
                    start+=1
                hash_map.pop(s[start])
                start+=1


            hash_map[s[end]] = end 
            longestSubstring = max(longestSubstring, end - start + 1)
            end+=1
        
        print(hash_map)
        return longestSubstring


    def bruteForce(self, s : str, k : int) -> int:
        longestSubstring = 0

        for i in range(len(s)):
            hash_set = set()
            for j in range(i,len(s)):
                hash_set.add(s[j])
                if len(hash_set) > k:
                    # compute and break
                    longestSubstring = max(longestSubstring, j - i)
                    break
            
        return longestSubstring


sol = Solution()
s = "aababbaddddddddddvcccc"
k=2
print(f"Longest substring with {k} distinct character in {s} are {sol.optimal(s,k)}")
