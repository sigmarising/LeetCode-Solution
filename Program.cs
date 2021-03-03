using System;
using System.Collections.Generic;
using Sword2Offer;

namespace LeetCode {
    class Program {
        static void Main(string[] args) {
            var test = new Problem41();

            Console.WriteLine(test.FindMedian());
            test.AddNum(1);
            test.AddNum(0);
            Console.WriteLine(test.FindMedian());
            test.AddNum(0);
            Console.WriteLine(test.FindMedian());
            test.AddNum(3);
            Console.WriteLine(test.FindMedian());
        }
    }
}
