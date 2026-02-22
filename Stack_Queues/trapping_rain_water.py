from typing import List

class Solution:
    prefixMax = []
    suffixMax = []

    def getPrefixMax(self, height: List[int]):
        n = len(height)
        self.prefixMax = height[:]
        for i in range(1,n):
            self.prefixMax = min(self.prefixMax[i-1],self.prefixMax[i])
        print(self.prefixMax)

    def getSuffixMax(self, height: List[int]):
        n = len(height)
        self.suffixMax = height[:]
        for i in range(n-1,0,-1):
            self.suffixMax = max(self.suffixMax[i+1],self.suffixMax[i])
        print(self.suffixMax)

    def trap(self, height: List[int]) -> int:
        self.getPrefixMax(height)
        self.getSuffixMax(height)

height = [0,1,0,2,1,0,1,3,2,1,2,1]
s = Solution()
s.trap(height)