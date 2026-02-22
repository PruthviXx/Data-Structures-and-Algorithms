#include <vector>
class Solution {
public:
    std::vector<int> singleNumber(std::vector<int>& nums) {
        long long numXor = 0;
        for (auto it : nums) numXor ^= it;
        long long rightBit = numXor ^ (numXor & (numXor - 1));
        int a = 0, b = 0;
        for (auto it : nums) {
            if (it & rightBit) a ^= it;
            else b ^= it;
        }
        return {a, b};
    }
};