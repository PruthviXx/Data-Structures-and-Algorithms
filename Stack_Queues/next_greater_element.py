from typing import List


class Solution:
    def bruteForce(self, nums1: List[int], nums2: List[int]) -> List[int]:
        ans = [] # Space : O(n)
        for i in range(0,len(nums1)): # Time: O(n^2)
            num1 = nums1[i]
            num2 = -1
            isGreater = True
            nextGreater = -1
            for j in range(0,len(nums2)):
                if nums2[j] == num1:
                    num2 = nums2[j]
                elif num2 != -1 and nums2[j]>num2:
                    if nextGreater == -1:
                        nextGreater = nums2[j]
                    isGreater = False
            if isGreater:
                ans.append(-1)
            else:
                ans.append(nextGreater)
        return ans

    def optimal(self, nums1: List[int], nums2: List[int]) -> List[int]:
        ans = []
        stack = []
        map = dict() # Space : O(3n)

        for num in reversed(nums2): # Time: O(2n)
            while stack and stack[-1] < num: 
                stack.pop()
            if not stack:
                map[num] = -1
            else:
                map[num] = stack[-1]
            stack.append(num)
        
        for num in nums1:
            ans.append(map[num])
        
        return ans

solution = Solution()
ans = solution.optimal([4,1,2],[1,3,4,2])
print(ans)