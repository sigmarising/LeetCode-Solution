using System;
using System.Collections.Generic;
using Sword2Offer;

namespace LeetCode {
    class Program {
        static void Main(string[] args) {
            var test = new Problem13();

            int[] data1 = { 3, 4, 5, 1, 2 };

            List<int> arr = new List<int>(data1);
            arr.Sort((x, y) => -x.CompareTo(y));
            Console.WriteLine(arr.ToArray()[0]);
            Console.WriteLine();
        }
    }
}
