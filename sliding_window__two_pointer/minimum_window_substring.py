class Solution:
    def bruteForce(self, s : str, k : str) ->  str:
        # base case
        if len(k) == 0:
            return ""
        
        matched = 0 
        hash_map = {}
        finalStr = ""
        finalcount = float("inf")
        
        for i in range(len(k)):
            if k[i] in hash_map:
                hash_map[k[i]] += 1
            else:
                hash_map[k[i]] = 1

        for i in range(len(s)):
            temp_map = hash_map.copy()
            temp_count = 0
            temp_str = ""
            for j in range(i,len(s)):
                if s[j] in temp_map:
                    temp_map[s[j]] -= 1
                    if temp_map[s[j]] == 0:
                        temp_map.pop(s[j])
                temp_str += s[j]
                temp_count += 1
                if not temp_map:
                    if temp_count <= finalcount:
                        finalcount = temp_count
                        finalStr = temp_str
                    break
        
        return finalStr

    def optimal(self, s : str, k : str) ->  str:
        min_length = float("inf")
        start_index = -1
        left = 0
        matched = 0
        n = len(s)
        m = len(k)

        if m > n:
            return ""

        need = [0] * 128 
        window = [0] * 128

        for i in range(m):
            need[ord(k[i])] += 1
        
        # print(need)

        for right in range(n):
            current = ord(s[right])
            window[current] += 1

            if need[current] > 0 and window[current] <= need[current]:
                matched += 1
            
            while matched == m:
                curr_len = right - left + 1

                if curr_len < min_length:
                    min_length = curr_len
                    start_index = left
                
                left_char = ord(s[left])
                window[left_char] -= 1

                if need[left_char] > 0 and window[left_char] < need[left_char]:
                    matched -= 1
                
                left += 1

        if start_index == -1:
            return ""
        
        return s[start_index : start_index + min_length] 
        
sol = Solution()
s = "ADOBECODEBANC"
k = "ABC"
print(sol.optimal(s,k))
