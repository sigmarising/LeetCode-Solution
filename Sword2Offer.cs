using System;
using System.Collections.Generic;
using System.Text;

namespace Sword2Offer {
    public class Problem03 {
        public int FindRepeatNumber(int[] nums) {
            Dictionary<int, int> store = new Dictionary<int, int>();

            foreach (int i in nums) {
                if (store.ContainsKey(i))
                    return i;
                else
                    store.Add(i, 1);
            }

            return -1;
        }
    }

    public class Problem04 {
        public bool FindNumberIn2DArrayPersonal(int[][] matrix, int target) {
            int n = matrix.Length; // n rows
            if (n == 0) return false;

            int m = matrix[0].Length; // m columns
            if (m == 0) return false;

            for (int i = 0; i < n; i++) {
                int min = matrix[i][0];
                int max = matrix[i][m - 1];

                if (min <= target && target <= max) {
                    List<int> arr = new List<int>(matrix[i]);
                    if (arr.BinarySearch(target) >= 0) return true;
                }
            }

            return false;
        }

        public bool FindNumberIn2DArrayOffical(int[][] matrix, int target) {
            int n = matrix.Length; // n rows
            if (n == 0) return false;
            int m = matrix[0].Length; // m columns
            if (m == 0) return false;

            int i = 0, j = m - 1;
            while (i <= n - 1 && j >= 0) {
                int num = matrix[i][j];

                if (target == num) return true;
                else if (target > num) i++;
                else j--;
            }

            return false;
        }
    }

    public class Problem05 {
        public string ReplaceSpace(string s) {
            StringBuilder builder = new StringBuilder(s);
            return builder.Replace(" ", "%20").ToString();
        }
    }

    public class Problem06 {
        public class ListNode {
            public int val;
            public ListNode next;
            public ListNode(int x) { val = x; }
        }
        public int[] ReversePrintPersonal(ListNode head) {
            ListNode oldCurrent = head;
            ListNode reverseRoot = null;

            while (oldCurrent != null) {
                ListNode newNode = new ListNode(oldCurrent.val);
                if (reverseRoot == null) {
                    newNode.next = null;
                    reverseRoot = newNode;
                }
                else {
                    newNode.next = reverseRoot;
                    reverseRoot = newNode;
                }
                oldCurrent = oldCurrent.next;
            }

            List<int> arr = new List<int>();
            ListNode reverseCurrent = reverseRoot;
            while (reverseCurrent != null) {
                arr.Add(reverseCurrent.val);
                reverseCurrent = reverseCurrent.next;
            }

            return arr.ToArray();
        }

        public int[] ReversePrintOffical(ListNode head) {
            Stack<int> stack = new Stack<int>();

            ListNode current = head;
            while (current != null) {
                stack.Push(current.val);
                current = current.next;
            }

            List<int> arr = new List<int>();
            while (stack.Count != 0) {
                arr.Add(stack.Pop());
            }

            return arr.ToArray();
        }
    }

    public class Problem07 {
        public class TreeNode {
            public int val;
            public TreeNode left;
            public TreeNode right;
            public TreeNode(int x) { val = x; }
        }
        public TreeNode BuildTree(int[] preorder, int[] inorder) {
            List<int> inorderList = new List<int>(inorder);

            TreeNode LeftRoot = null;
            TreeNode RightRoot = null;
            Boolean hasValue = false;

            if (preorder.Length != 0) {
                hasValue = true;
                int index = inorderList.IndexOf(preorder[0]);

                LeftRoot = index > 0 ?
                   BuildTree(preorder[1..(index + 1)], inorder[0..index]) :
                   null;
                RightRoot = index < inorder.Length - 1 ?
                   BuildTree(preorder[(1 + index)..preorder.Length], inorder[(index + 1)..inorder.Length]) :
                   null;
            }

            if (!hasValue) return null;

            TreeNode currentNode = new TreeNode(preorder[0]);
            currentNode.left = LeftRoot;
            currentNode.right = RightRoot;
            return currentNode;
        }
    }

    public class Problem09 {
        public class CQueue {
            private Stack<int> stackInsert;
            private Stack<int> StackDelete;

            public CQueue() {
                stackInsert = new Stack<int>();
                StackDelete = new Stack<int>();
            }

            public void AppendTail(int value) {
                stackInsert.Push(value);
            }

            public int DeleteHead() {
                if (StackDelete.Count != 0)
                    return StackDelete.Pop();

                if (stackInsert.Count == 0)
                    return -1;

                while (stackInsert.Count != 0) {
                    StackDelete.Push(stackInsert.Pop());
                }
                return StackDelete.Pop();
            }
        }
    }

    public class Problem10_1 {
        public int Fib(int n) {
            long x = 0;
            long y = 1;
            if (n == 0) return (int)x;
            else if (n == 1) return (int)y;
            else {
                for (int i = 2; i <= n; i++) {
                    long z = (x + y) % 1000000007L;
                    (x, y) = (y, z);
                }
            }
            return (int)y;
        }
    }

    public class Problem10_2 {
        public int NumWays(int n) {
            if (n == 0) return 1;

            long x = 1;
            long y = 2;
            if (n == 1) return (int)x;
            if (n == 2) return (int)y;

            for (int i = 3; i <= n; i++) {
                (x, y) = (y, (x + y) % 1000000007);
            }
            return (int)y;
        }
    }

    public class Problem11 {
        public int MinArray(int[] numbers) {
            int i = 0;
            int j = numbers.Length - 1;

            while (i < j) {
                int k = (i + j) / 2;
                if (numbers[k] < numbers[j]) j = k;
                else if (numbers[k] > numbers[j]) i = k + 1;
                else j--;
            }

            return numbers[i];
        }
    }

    public class Problem12 {
        private List<(int x, int y)> FindSourcePositions(char[][] board, char startChar) {
            List<(int x, int y)> result = new List<(int, int)>();
            int n = board.Length;
            int m = board[0].Length;

            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (board[i][j] == startChar)
                        result.Add((i, j));

            return result;
        }

        private bool FindWithDFS(char[][] board, bool[][] travelRecord, string word, int currentCharPosition, (int x, int y) prePosition) {
            int n = board.Length;
            int m = board[0].Length;

            // Get all positions of next step
            (int x, int y) up = (prePosition.x - 1, prePosition.y);
            (int x, int y) down = (prePosition.x + 1, prePosition.y);
            (int x, int y) right = (prePosition.x, prePosition.y + 1);
            (int x, int y) left = (prePosition.x, prePosition.y - 1);
            (int x, int y)[] actions = { up, down, right, left };

            foreach ((int x, int y) currentAction in actions) {
                if (
                    (0 <= currentAction.x && currentAction.x < n) &&
                    (0 <= currentAction.y && currentAction.y < m) &&
                    (travelRecord[currentAction.x][currentAction.y]) &&
                    (board[currentAction.x][currentAction.y] == word[currentCharPosition])
                ) {
                    if (currentCharPosition == word.Length - 1)
                        return true;
                    else {
                        travelRecord[currentAction.x][currentAction.y] = false;
                        if (FindWithDFS(board, travelRecord, word, currentCharPosition + 1, currentAction))
                            return true;
                        travelRecord[currentAction.x][currentAction.y] = true;
                    }
                }
            }

            return false;
        }

        public bool Exist(char[][] board, string word) {
            if (board == null || board.Length == 0 || board[0].Length == 0) return false;
            if (word.Length == 0) return true;

            // Get the travelRecord arr
            // record whether the currentPosition is traveled
            int n = board.Length;
            int m = board[0].Length;
            bool[][] travelRecord = new bool[n][];
            for (int i = 0; i < n; i++) {
                travelRecord[i] = new bool[m];
                for (int j = 0; j < m; j++)
                    travelRecord[i][j] = true;
            }

            // Find all start Points
            List<(int, int)> sourcePositions = FindSourcePositions(board, word[0]);
            if (word.Length == 1 && sourcePositions.Count != 0)
                return true;

            // Start DFS
            foreach ((int x, int y) position in sourcePositions) {
                travelRecord[position.x][position.y] = false;
                if (FindWithDFS(board, travelRecord, word, 1, position))
                    return true;
                travelRecord[position.x][position.y] = true;
            }

            return false;
        }
    }

    public class Problem13 {
        private int GetDigitSum(int x) {
            int sum = 0;
            int remain = x;

            while (remain != 0) {
                sum += remain % 10;
                remain /= 10;
            }

            return sum;
        }
        public int MovingCount(int m, int n, int k) {
            if (m <= 0 || n <= 0) return 0;
            if (k < 0) return 0;

            int result = 1;
            bool[,] map = new bool[m, n];
            map[0, 0] = true;

            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0 || GetDigitSum(i) + GetDigitSum(j) > k)
                        continue;

                    bool fromTop = i > 0 ? map[i - 1, j] : false;
                    bool fromLeft = j > 0 ? map[i, j - 1] : false;
                    map[i, j] = fromTop || fromLeft;

                    if (map[i, j]) result += 1;
                }

            return result;
        }
    }

    public class Problem14_1 {
        public int CuttingRope(int n) {
            if (n < 2) return 0;

            int[] multiLenResult = new int[n + 1];
            multiLenResult[2] = 1;

            for (int i = 3; i <= n; i++) {
                for (int j = 2; j < i; j++) {
                    int temp = Math.Max(multiLenResult[i - j] * j, (i - j) * j);
                    multiLenResult[i] = Math.Max(multiLenResult[i], temp);
                }
            }

            return multiLenResult[n];
        }
    }

    public class Problem14_2 {
        public int CuttingRope(int n) {
            if (n <= 3) return n - 1;

            int b = n % 3;
            int p = 1000000007;
            long rem = 1;
            long x = 3;

            for (int a = n / 3 - 1; a > 0; a /= 2) {
                if (a % 2 == 1)
                    rem = (rem * x) % p;
                x = (x * x) % p;
            }

            if (b == 0) return (int)(rem * 3 % p);
            if (b == 1) return (int)(rem * 4 % p);
            else return (int)(rem * 6 % p);
        }
    }

    public class Problem15 {
        public int HammingWeight(uint n) {
            int result = 0;
            uint numberNow = n;

            while (numberNow != 0) {
                result += 1;
                numberNow &= numberNow - 1;
            }

            return result;
        }
    }

    public class Problem16 {
        public double MyPow(double x, int n) {
            if (x == 0) return 0.0;

            double multiply = 1.0;
            if (n < 0)
                (x, n) = (1 / x, -n);

            while (n != 0) {
                if (n % 2 != 0)
                    multiply *= x;
                x *= x;
                n /= 2;
            }

            return multiply;
        }
    }

    public class Problem17 {
        public int[] PrintNumbers(int n) {
            if (n <= 0) return null;

            List<int> arr = new List<int>();
            int numMax = 10;
            for (int i = 1; i < n; i++)
                numMax = numMax * 10;

            for (int i = 1; i < numMax; i++)
                arr.Add(i);

            return arr.ToArray();
        }
    }

    public class Problem18 {
        public class ListNode {
            public int val;
            public ListNode next;
            public ListNode(int x) { val = x; }
        }
        public ListNode DeleteNode(ListNode head, int val) {
            ListNode root = head;
            ListNode current = head, previous = null;

            while(current != null) {
                if (current.val == val)
                    if (previous == null) return current.next;
                    else {
                        previous.next = current.next;
                        break;
                    }
                previous = current;
                current = current.next;
            }

            return root;
        }
    }
    public class Problem19 {
        public bool IsMatch(string s, string p) {
            int m = s.Length;
            int n = p.Length;

            bool[,] f = new bool[m + 1, n + 1];
            f[0, 0] = true;
            for (int i = 0; i <= m; i++) {
                for (int j =1; j<=n; j++) {
                    if(p[j-1] == '*') {
                        f[i, j] = f[i, j - 2];
                        if (Matches(s, p, i, j -1)) {
                            f[i, j] = f[i, j] || f[i - 1, j];
                        }
                    } else {
                        if (Matches(s, p, i, j)) {
                            f[i, j] = f[i - 1, j - 1];
                        }
                    }
                }
            }
            return f[m, n];
        }

        public bool Matches(string s, string p, int i, int j) {
            if (i == 0) return false;
            if (p[j - 1] == '.') return true;
            return s[i - 1] == p[j - 1];
        }
    }

    public class Problem20 {
        private Dictionary<char, int>[] states = {
            new Dictionary<char, int>() { [' '] = 0, ['s'] = 1, ['d'] = 2, ['.'] = 4 },
            new Dictionary<char, int>() { ['d'] = 2, ['.'] = 4 },
            new Dictionary<char, int>() { ['d'] = 2, ['.'] = 3, ['e'] = 5, [' '] = 8 },
            new Dictionary<char, int>() { ['d'] = 3, ['e'] = 5, [' '] = 8 },
            new Dictionary<char, int>() { ['d'] = 3},
            new Dictionary<char, int>() { ['s'] = 6, ['d'] = 7 },
            new Dictionary<char, int>() { ['d'] = 7 },
            new Dictionary<char, int>() { ['d'] = 7, [' '] = 8 },
            new Dictionary<char, int>() { [' '] = 8 }
        };

        public bool IsNumber(string s) {
            int p = 0;
            char t;
            foreach(char c in s) {
                if ('0' <= c && c <= '9') t = 'd';
                else if (c == '+' || c == '-') t = 's';
                else if (c == 'e' || c == 'E') t = 'e';
                else if (c == '.' || c == ' ') t = c;
                else t = '?';

                if (!states[p].ContainsKey(t)) return false;
                p = states[p][t];
            }

            return p == 2 || p == 3 || p == 7 || p == 8;
        }
    }

    public class Problem21 {
        public int[] Exchange(int[] nums) {
            int i = 0, j = nums.Length - 1;
            while(i < j) {
                while (i < j && nums[i] % 2 == 1) i++;
                while (i < j && nums[j] % 2 == 0) j--;

                (nums[i], nums[j]) = (nums[j], nums[i]);
            }

            return nums;
        }
    }

    public class Problem22 {
        public class ListNode {
            public int val;
            public ListNode next;
            public ListNode(int x) { val = x; }
        }

        public ListNode GetKthFromEnd(ListNode head, int k) {
            ListNode root = head, last = head;
            for (int i = 1; i < k; i++)
                last = last.next;
            
            while(last.next != null) {
                root = root.next;
                last = last.next;
            }

            return root;
        }
    }

    public class Problem23 {
        public class ListNode {
            public int val;
            public ListNode next;
            public ListNode(int x) { val = x; }
        }

        public ListNode ReverseList(ListNode head) {
            ListNode newHead = null, current = head;
            while (current != null) {
                ListNode temp = current;
                current = current.next;

                if (newHead == null) {
                    newHead = temp;
                    newHead.next = null;
                } else {
                    temp.next = newHead;
                    newHead = temp;
                }
            }

            return newHead;
        }
    }

    public class Problem25 {
        public class ListNode {
            public int val;
            public ListNode next;
            public ListNode(int x) { val = x; }
        }

        private void AddNode(ref ListNode root, ref ListNode tail, ListNode node) {
            if (root == null) {
                root = node;
                tail = node;
            }
            else {
                tail.next = node;
                tail = node;
            }
        }

        public ListNode MergeTwoLists(ListNode l1, ListNode l2) {
            ListNode root1 = l1, root2 = l2;
            if (root1 == null) return l2;
            if (root2 == null) return l1;

            ListNode root = null, tail = null;
            
            while(root1 != null && root2 != null) {
                if (root1.val <= root2.val) {
                    AddNode(ref root, ref tail, root1);
                    root1 = root1.next;
                } else {
                    AddNode(ref root, ref tail, root2);
                    root2 = root2.next;
                }
            }
            if (root1 == null) tail.next = root2;
            else tail.next = root1;

            return root;
        }
    }

    public class Problem26 {
        public class TreeNode {
            public int val;
            public TreeNode left;
            public TreeNode right;
            public TreeNode(int x) { val = x; }
        }

        private bool JudgeTree(TreeNode A, TreeNode B) {
            if (B == null) return true;
            if (A == null) return false;
            if (A.val != B.val) return false;

            return JudgeTree(A.left, B.left) && JudgeTree(A.right, B.right);
        }

        public bool IsSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) return false;

            return JudgeTree(A, B) || IsSubStructure(A.left, B) || IsSubStructure(A.right, B);
        }
    }

    public class Problem27 {
        public class TreeNode {
            public int val;
            public TreeNode left;
            public TreeNode right;
            public TreeNode(int x) { val = x; }
        }

        private void Mirror(TreeNode root) {
            if (root == null) return;

            Mirror(root.left);
            Mirror(root.right);
            (root.left, root.right) = (root.right, root.left);
        }

        public TreeNode MirrorTree(TreeNode root) {
            Mirror(root);
            return root;
        }
    }

    public class Problem28 {
        public class TreeNode {
            public int val;
            public TreeNode left;
            public TreeNode right;
            public TreeNode(int x) { val = x; }
        }

        private bool Judge(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null || left.val != right.val) return false;

            return Judge(left.left, right.right) && Judge(left.right, right.left);
        }

        public bool IsSymmetric(TreeNode root) {
            return root == null ? true : Judge(root.left, root.right);
        }
    }

    public class Problem29 {
        public int[] SpiralOrder(int[][] matrix) {
            List<int> arr = new List<int>();
            if (matrix.Length == 0) return arr.ToArray();

            int l = 0, r = matrix[0].Length - 1, t = 0, b = matrix.Length - 1;
            while (true) {
                for (int i = l; i <= r; i++) arr.Add(matrix[t][i]); // left to right.
                if (++t > b) break;
                for (int i = t; i <= b; i++) arr.Add(matrix[i][r]); // top to bottom.
                if (l > --r) break;
                for (int i = r; i >= l; i--) arr.Add(matrix[b][i]); // right to left.
                if (t > --b) break;
                for (int i = b; i >= t; i--) arr.Add(matrix[i][l]); // bottom to top.
                if (++l > r) break;
            }
            return arr.ToArray();
        }
    }

    public class Problem30 {
        public class MinStack {
            private Stack<int> data;
            private Stack<int> min;

            /** initialize your data structure here. */
            public MinStack() {
                data = new Stack<int>();
                min = new Stack<int>();
            }

            public void Push(int x) {
                data.Push(x);
                if (min.Count == 0 || min.Peek() >= x)
                    min.Push(x);
            }

            public void Pop() {
                int x = data.Pop();
                if (x == min.Peek())
                    min.Pop();
            }

            public int Top() {
                return data.Peek();
            }

            public int Min() {
                return min.Peek();
            }
        }
    }

    public class Problem31 {
        public bool ValidateStackSequences(int[] pushed, int[] popped) {
            Stack<int> stack = new Stack<int>();
            int index = 0;
            foreach(int number in pushed) {
                stack.Push(number);
                while(stack.Count != 0 && index < popped.Length && stack.Peek() == popped[index]) {
                    stack.Pop();
                    index++;
                }
            }
            return stack.Count == 0;
        }
    }

    public class Problem32 {
        public class TreeNode {
            public int val;
            public TreeNode left;
            public TreeNode right;
            public TreeNode(int x) { val = x; }
        }

        public int[] LevelOrder(TreeNode root) {
            if (root == null) return new int[0];

            Queue<TreeNode> queue = new Queue<TreeNode>();
            List<int> result = new List<int>();
            queue.Enqueue(root);

            while (queue.Count != 0) {

                TreeNode x = queue.Dequeue();
                result.Add(x.val);
                if (x.left != null) queue.Enqueue(x.left);
                if (x.right != null) queue.Enqueue(x.right);
            }

            return result.ToArray();
        }
    }

    public class Problem32_2 {
        public class TreeNode {
            public int val;
            public TreeNode left;
            public TreeNode right;
            public TreeNode(int x) { val = x; }
        }

        public IList<IList<int>> LevelOrder(TreeNode root) {
            IList<IList<int>> result = new List<IList<int>>();
            Queue<TreeNode> queue = new Queue<TreeNode>();

            if (root != null) queue.Enqueue(root);
            while(queue.Count != 0) {
                int currentLevelSize = queue.Count;
                IList<int> currentLevelList = new List<int>();
                for(int i = 0; i < currentLevelSize; i++) {
                    TreeNode x = queue.Dequeue();
                    currentLevelList.Add(x.val);

                    if (x.left != null) queue.Enqueue(x.left);
                    if (x.right != null) queue.Enqueue(x.right);
                }

                result.Add(currentLevelList);
            }

            return result;
        }
    }

    public class Problem32_3 {
        public class TreeNode {
            public int val;
            public TreeNode left;
            public TreeNode right;
            public TreeNode(int x) { val = x; }
        }

        public IList<IList<int>> LevelOrder(TreeNode root) {
            IList<IList<int>> result = new List<IList<int>>();
            Queue<TreeNode> queue = new Queue<TreeNode>();
            bool needReverse = false;

            if (root != null) queue.Enqueue(root);
            while (queue.Count != 0) {
                int currentLevelSize = queue.Count;
                List<int> currentLevelList = new List<int>();
                for (int i = 0; i < currentLevelSize; i++) {
                    TreeNode x = queue.Dequeue();
                    currentLevelList.Add(x.val);

                    if (x.left != null) queue.Enqueue(x.left);
                    if (x.right != null) queue.Enqueue(x.right);
                }
                if (needReverse) currentLevelList.Reverse();
                needReverse = !needReverse;

                result.Add(currentLevelList);
            }

            return result;
        }
    }

    public class Problem33 {
        public bool VerifyPostorder(int[] postorder) {
            return Judge(postorder, 0, postorder.Length - 1);
        }

        private bool Judge(int[] postorder, int i, int j) {
            if (i >= j) return true;
            int p = i;
            while (postorder[p] < postorder[j]) p++;
            int m = p;
            while (postorder[p] > postorder[j]) p++;

            return p == j && Judge(postorder, i, m - 1) && Judge(postorder, m, j - 1);
        }
    }

    public class Problem34 {
        public class TreeNode {
            public int val;
            public TreeNode left;
            public TreeNode right;
            public TreeNode(int x) { val = x; }
        }

        private IList<IList<int>> finalList = new List<IList<int>>();
        private List<int> currentList = new List<int>();

        public IList<IList<int>> PathSum(TreeNode root, int sum) {
            Finding(root, 0, sum);
            return finalList;
        }

        private bool isLeaf(TreeNode node) {
            if (node.left == null && node.right == null) return true;
            return false;
        }

        private void Finding(TreeNode root, int preSum, int sum) {
            if (root == null) return;

            currentList.Add(root.val);
            int currentSum = preSum + root.val;
            if (currentSum == sum && isLeaf(root)) finalList.Add(new List<int>(currentList));
            else {
                Finding(root.left, currentSum, sum);
                Finding(root.right, currentSum, sum);
            }
            currentList.RemoveAt(currentList.Count - 1);
        }
    }

    public class Problem35 {
        public class Node {
            public int val;
            public Node next;
            public Node random;

            public Node(int _val) {
                val = _val;
                next = null;
                random = null;
            }
        }

        public Node CopyRandomList(Node head) {
            if (head == null) return null;

            Dictionary<Node, Node> mapOfNode = new Dictionary<Node, Node>();
            Node pointer = head;

            while(pointer != null) {
                mapOfNode.Add(pointer, new Node(pointer.val));
                pointer = pointer.next;
            }

            pointer = head;
            while(pointer != null) {
                mapOfNode[pointer].next = pointer.next != null ? mapOfNode[pointer.next] : null;
                mapOfNode[pointer].random = pointer.random != null ? mapOfNode[pointer.random] : null;
                pointer = pointer.next;
            }

            return mapOfNode[head];
        }
    }

    public class Problem36 {
        public class Node {
            public int val;
            public Node left;
            public Node right;

            public Node() { }

            public Node(int _val) {
                val = _val;
                left = null;
                right = null;
            }

            public Node(int _val, Node _left, Node _right) {
                val = _val;
                left = _left;
                right = _right;
            }
        }

        private Node head, pre;
        public Node TreeToDoublyList(Node root) {
            if (root == null) return null;
            Search(root);

            head.left = pre;
            pre.right = head;
            return head;
        }

        private void Search(Node node) {
            if (node == null) return;

            Search(node.left);

            if (pre == null) head = node;
            else pre.right = node;
            node.left = pre;
            pre = node;
            
            Search(node.right);
        }
    }

    public class Problem38 {
        List<String> result = new List<string>();
        char[] c;

        public string[] Permutation(string s) {
            c = s.ToCharArray();
            Search(0);
            return result.ToArray();
        }

        private void Search(int x) {
            if (x == c.Length - 1) {
                result.Add(new string(c));
                return;
            }

            HashSet<char> set = new HashSet<char>();
            for (int i = x; i < c.Length; i++) {
                if (set.Contains(c[i])) continue;
                set.Add(c[i]);

                (c[i], c[x]) = (c[x], c[i]);
                Search(x + 1);
                (c[i], c[x]) = (c[x], c[i]);
            }
        }
    }

    public class Problem39 {
        public int MajorityElement(int[] nums) {
            int len = nums.Length / 2;
            Dictionary<int, int> dict = new Dictionary<int, int>();

            foreach(int i in nums) {
                if (dict.ContainsKey(i)) {
                    dict[i] += 1;
                } else {
                    dict.Add(i, 1);
                }
                if (dict[i] > len) return i;
            }

            return -1;
        }
    }

    public class Problem40 {
        public int[] GetLeastNumbers(int[] arr, int k) {
            List<int> list = new List<int>(arr);
            list.Sort();

            return list.GetRange(0, k).ToArray();
        }
    }

    public class Problem42 {
        public int MaxSubArray(int[] nums) {
            List<int> arr = new List<int>(nums);
            int max = arr[0];
            for (int i = 1; i < arr.Count; i++) {
                nums[i] += Math.Max(nums[i - 1], 0);
                max = Math.Max(max, nums[i]);
            }
            return max;
        }
    }

    public class Problem44 {
        public int FindNthDigit(int n) {
            if (n == 0) return 0;

            long digit = 1, start = 1, count = 9;
            while (n > count) {
                n -= (int)count;
                digit += 1;
                start *= 10;
                count = 9 * start * digit;
            }
            long num = start + (n - 1) / digit;
            return Convert.ToString(num)[(n - 1) % (int)digit] - '0';
        }
    }

    public class Problem45 {
        public string MinNumber(int[] nums) {
            int MyCompare(int x, int y) {
                int CompareStr(string x, string y) {
                    for (int i = 0; i < x.Length; i++) {
                        if (x[i] < y[i]) return -1;
                        if (x[i] > y[i]) return 1;
                    }
                    return 0;
                }
                string a = Convert.ToString(x);
                string b = Convert.ToString(y);
                (a, b) = (a + b, b + a);
                int result = CompareStr(a, b);
                if (result < 0) return -1;
                if (result > 0) return 1;
                return 0;
            }
            
            List<int> arr = new List<int>(nums);
            arr.Sort(MyCompare);
            return string.Join("", arr);
        }
    }

    public class Problem46 {
        public int TranslateNum(int num) {
            string src = Convert.ToString(num);
            int p = 0, q = 0, r = 1;
            for (int i = 0; i < src.Length; i++) {
                (p, q, r) = (q, r, 0);
                r += q;
                if (i == 0) continue;
                string pre = src.Substring(i - 1, 2);
                if (pre.CompareTo("25") <= 0 && pre.CompareTo("10") >= 0) r += p;
            }
            return r;
        }
    }

    public class Problem47 {
        public int MaxValue(int[][] grid) {
            int m = grid.Length, n = grid[0].Length;

            for (int j = 1; j < n; j++) grid[0][j] += grid[0][j - 1];
            for (int i = 1; i < m; i++) grid[i - 1]
        }
    }
}
