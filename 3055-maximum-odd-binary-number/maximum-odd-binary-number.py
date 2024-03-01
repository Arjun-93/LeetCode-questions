class Solution:
    def maximumOddBinaryNumber(self, s: str) -> str:
        ones_count = s.count('1')
        zeros_count = len(s) - ones_count
        if ones_count == 1:
            max_odd_number = '0' * zeros_count + '1'
        else:
            max_odd_number = '1' * (ones_count - 1) + '0' * zeros_count + '1'

        return max_odd_number