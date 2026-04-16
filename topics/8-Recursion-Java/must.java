public class must
{
    
}
/* 
What actually exists is:
👉 **A small set of patterns (~5–6) that cover 90% of problems**
👉 If you master these, recursion + backtracking is basically done

So I’ll give you exactly that—**pattern-wise, no fluff, Java, core logic, when to use, why it works**

---

# 🧠 First: The Only Mental Model You Need

Every recursion problem = **3 decisions**

```text
1. What is my state?  (parameters)
2. When do I stop?    (base case)
3. What choices do I have? (recursion calls)
```

If you can’t answer these → you don’t understand the problem yet.

---

# 🔥 PATTERN 1: PICK / NOT PICK (Subsequence Pattern)

### 🧩 When to use:

* Subsets
* Subsequences
* “include or exclude”
* target sum, combinations

---

### 💡 Core Idea:

At every index → 2 choices:

* take element
* don’t take element

---

### 🧾 Template

```java
void solve(int index, int[] arr, List<Integer> current) {

    // base case
    if (index == arr.length) {
        System.out.println(current);
        return;
    }

    // PICK
    current.add(arr[index]);
    solve(index + 1, arr, current);

    // BACKTRACK
    current.remove(current.size() - 1);

    // NOT PICK
    solve(index + 1, arr, current);
}
```

---

### 🧠 Why this works:

You’re building a **binary tree of decisions**

Each level → one element
Each branch → pick or skip

Total nodes → `2^n`

---

### ⚠️ Common Mistake:

* Forgetting backtracking (`remove`)
  → leads to wrong answers

---

# 🔥 PATTERN 2: FOR LOOP + RECURSION (Combination Pattern)

### 🧩 When to use:

* combinations
* subsets without duplicates
* combination sum

---

### 💡 Core Idea:

Instead of binary choice, you explore **all future choices using loop**

---

### 🧾 Template

```java
void solve(int index, int[] arr, List<Integer> current) {

    System.out.println(current);

    for (int i = index; i < arr.length; i++) {

        current.add(arr[i]);

        solve(i + 1, arr, current);

        // BACKTRACK
        current.remove(current.size() - 1);
    }
}
```

---

### 🧠 Why this works:

* Loop decides next element
* Recursion handles deeper levels

---

### ⚠️ Difference from Pattern 1:

| Pattern 1       | Pattern 2           |
| --------------- | ------------------- |
| binary choice   | multiple choices    |
| pick / not pick | choose next element |

---

# 🔥 PATTERN 3: PERMUTATIONS (Swap / Visited)

### 🧩 When to use:

* permutations of array/string
* order matters

---

## ✅ Approach 1: Using Visited

```java
void solve(int[] arr, boolean[] used, List<Integer> current) {

    if (current.size() == arr.length) {
        System.out.println(current);
        return;
    }

    for (int i = 0; i < arr.length; i++) {

        if (used[i]) continue;

        used[i] = true;
        current.add(arr[i]);

        solve(arr, used, current);

        // BACKTRACK
        current.remove(current.size() - 1);
        used[i] = false;
    }
}
```

---

## ✅ Approach 2: Swap (More optimal)

```java
void solve(int index, int[] arr) {

    if (index == arr.length) {
        System.out.println(Arrays.toString(arr));
        return;
    }

    for (int i = index; i < arr.length; i++) {

        swap(arr, index, i);

        solve(index + 1, arr);

        // BACKTRACK
        swap(arr, index, i);
    }
}
```

---

### 🧠 Why this works:

Each position tries every possible element

---

# 🔥 PATTERN 4: CONSTRAINT BASED (Backtracking)

### 🧩 When to use:

* N-Queens
* Sudoku
* Valid combinations only

---

### 💡 Core Idea:

👉 “Try → Check → Recurse → Undo”

---

### 🧾 Template

```java
void solve(...) {

    if (solution found) {
        return;
    }

    for (each choice) {

        if (isValid(choice)) {

            makeMove();

            solve(...);

            // BACKTRACK
            undoMove();
        }
    }
}
```

---

### 🧠 This is REAL backtracking

Without constraint → just recursion
With constraint → backtracking

---

# 🔥 PATTERN 5: STRING / PARTITION (Palindrome, etc.)

### 🧩 When to use:

* palindrome partition
* word break
* split problems

---

### 🧾 Template

```java
void solve(int index, String s, List<String> current) {

    if (index == s.length()) {
        System.out.println(current);
        return;
    }

    for (int i = index; i < s.length(); i++) {

        String part = s.substring(index, i + 1);

        if (isValid(part)) {

            current.add(part);

            solve(i + 1, s, current);

            // BACKTRACK
            current.remove(current.size() - 1);
        }
    }
}
```

---

# 🔥 PATTERN 6: COUNT / RETURN VALUE RECURSION

### 🧩 When to use:

* count ways
* fibonacci type
* number of subsets

---

### 🧾 Template

```java
int solve(int index, int[] arr) {

    if (index == arr.length) {
        return 1;
    }

    int take = solve(index + 1, arr);
    int notTake = solve(index + 1, arr);

    return take + notTake;
}
```

---

# ⚠️ The Real Trap (Most People Fail Here)

You think:

> “I learned recursion”

But you actually didn’t until you can answer this instantly:

### For ANY problem:

1. What is changing? → index / state
2. What are choices? → loop / pick-not-pick
3. Where is base case?
4. Where is backtracking step?

---

# 🔥 Final Compression (Memorize This)

```text
1. Subsequence → pick / not pick
2. Combination → for loop + recursion
3. Permutation → swap / visited
4. Constraint → try → check → undo
5. Partition → substring loop
6. Count → return values
```

That’s it. No magic.

---

# 🚀 What You Should Do Next (No excuses)

Do NOT just read.

Solve these in Java:

1. Subsets
2. Subsets II
3. Permutations
4. Combination Sum
5. N-Queens

If you struggle → you didn’t understand patterns, you just read them.

---

If you want next level, I’ll:
👉 map each Leetcode problem → exact pattern
👉 show how to identify pattern in <10 seconds

But first—internalize this.
Good—this is the right demand. But don’t fool yourself:
There is **no single magical recursion template that solves everything**.

What actually exists is:
👉 **A small set of patterns (~5–6) that cover 90% of problems**
👉 If you master these, recursion + backtracking is basically done

So I’ll give you exactly that—**pattern-wise, no fluff, Java, core logic, when to use, why it works**

---

# 🧠 First: The Only Mental Model You Need

Every recursion problem = **3 decisions**

```text
1. What is my state?  (parameters)
2. When do I stop?    (base case)
3. What choices do I have? (recursion calls)
```

If you can’t answer these → you don’t understand the problem yet.

---

# 🔥 PATTERN 1: PICK / NOT PICK (Subsequence Pattern)

### 🧩 When to use:

* Subsets
* Subsequences
* “include or exclude”
* target sum, combinations

---

### 💡 Core Idea:

At every index → 2 choices:

* take element
* don’t take element

---

### 🧾 Template

```java
void solve(int index, int[] arr, List<Integer> current) {

    // base case
    if (index == arr.length) {
        System.out.println(current);
        return;
    }

    // PICK
    current.add(arr[index]);
    solve(index + 1, arr, current);

    // BACKTRACK
    current.remove(current.size() - 1);

    // NOT PICK
    solve(index + 1, arr, current);
}
```

---

### 🧠 Why this works:

You’re building a **binary tree of decisions**

Each level → one element
Each branch → pick or skip

Total nodes → `2^n`

---

### ⚠️ Common Mistake:

* Forgetting backtracking (`remove`)
  → leads to wrong answers

---

# 🔥 PATTERN 2: FOR LOOP + RECURSION (Combination Pattern)

### 🧩 When to use:

* combinations
* subsets without duplicates
* combination sum

---

### 💡 Core Idea:

Instead of binary choice, you explore **all future choices using loop**

---

### 🧾 Template

```java
void solve(int index, int[] arr, List<Integer> current) {

    System.out.println(current);

    for (int i = index; i < arr.length; i++) {

        current.add(arr[i]);

        solve(i + 1, arr, current);

        // BACKTRACK
        current.remove(current.size() - 1);
    }
}
```

---

### 🧠 Why this works:

* Loop decides next element
* Recursion handles deeper levels

---

### ⚠️ Difference from Pattern 1:

| Pattern 1       | Pattern 2           |
| --------------- | ------------------- |
| binary choice   | multiple choices    |
| pick / not pick | choose next element |

---

# 🔥 PATTERN 3: PERMUTATIONS (Swap / Visited)

### 🧩 When to use:

* permutations of array/string
* order matters

---

## ✅ Approach 1: Using Visited

```java
void solve(int[] arr, boolean[] used, List<Integer> current) {

    if (current.size() == arr.length) {
        System.out.println(current);
        return;
    }

    for (int i = 0; i < arr.length; i++) {

        if (used[i]) continue;

        used[i] = true;
        current.add(arr[i]);

        solve(arr, used, current);

        // BACKTRACK
        current.remove(current.size() - 1);
        used[i] = false;
    }
}
```

---

## ✅ Approach 2: Swap (More optimal)

```java
void solve(int index, int[] arr) {

    if (index == arr.length) {
        System.out.println(Arrays.toString(arr));
        return;
    }

    for (int i = index; i < arr.length; i++) {

        swap(arr, index, i);

        solve(index + 1, arr);

        // BACKTRACK
        swap(arr, index, i);
    }
}
```

---

### 🧠 Why this works:

Each position tries every possible element

---

# 🔥 PATTERN 4: CONSTRAINT BASED (Backtracking)

### 🧩 When to use:

* N-Queens
* Sudoku
* Valid combinations only

---

### 💡 Core Idea:

👉 “Try → Check → Recurse → Undo”

---

### 🧾 Template

```java
void solve(...) {

    if (solution found) {
        return;
    }

    for (each choice) {

        if (isValid(choice)) {

            makeMove();

            solve(...);

            // BACKTRACK
            undoMove();
        }
    }
}
```

---

### 🧠 This is REAL backtracking

Without constraint → just recursion
With constraint → backtracking

---

# 🔥 PATTERN 5: STRING / PARTITION (Palindrome, etc.)

### 🧩 When to use:

* palindrome partition
* word break
* split problems

---

### 🧾 Template

```java
void solve(int index, String s, List<String> current) {

    if (index == s.length()) {
        System.out.println(current);
        return;
    }

    for (int i = index; i < s.length(); i++) {

        String part = s.substring(index, i + 1);

        if (isValid(part)) {

            current.add(part);

            solve(i + 1, s, current);

            // BACKTRACK
            current.remove(current.size() - 1);
        }
    }
}
```

---

# 🔥 PATTERN 6: COUNT / RETURN VALUE RECURSION

### 🧩 When to use:

* count ways
* fibonacci type
* number of subsets

---

### 🧾 Template

```java
int solve(int index, int[] arr) {

    if (index == arr.length) {
        return 1;
    }

    int take = solve(index + 1, arr);
    int notTake = solve(index + 1, arr);

    return take + notTake;
}
```

---

# ⚠️ The Real Trap (Most People Fail Here)

You think:

> “I learned recursion”

But you actually didn’t until you can answer this instantly:

### For ANY problem:

1. What is changing? → index / state
2. What are choices? → loop / pick-not-pick
3. Where is base case?
4. Where is backtracking step?

---

# 🔥 Final Compression (Memorize This)

```text
1. Subsequence → pick / not pick
2. Combination → for loop + recursion
3. Permutation → swap / visited
4. Constraint → try → check → undo
5. Partition → substring loop
6. Count → return values
```

That’s it. No magic.

---

# 🚀 What You Should Do Next (No excuses)

Do NOT just read.

Solve these in Java:

1. Subsets
2. Subsets II
3. Permutations
4. Combination Sum
5. N-Queens

If you struggle → you didn’t understand patterns, you just read them.

---

If you want next level, I’ll:
👉 map each Leetcode problem → exact pattern
👉 show how to identify pattern in <10 seconds

But first—internalize this.
*/