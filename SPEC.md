1. What it Does: It is a CLI program that will have the exact same functionality as Zetamac. A 120-second 
timed session, using Zetamac's default ranges (addition 2–100 + 2–100; subtraction as the reverse of addition,
 so never negative; multiplication 2–12 × 2–100; division as the reverse of multiplication, so always a 
 whole number). Every answer logged to a CSV file, and an end-of-session summary of your accuracy and average
 time taken per operation.

2. Example Session:
$ java Trainer
120 seconds. Go.
47 + 38 = 85        ✓
9 × 64 = 566        ✗ (576. 2 tries and then it moves on)
...
Time! Score: 31
add: 12/12, avg 2.1 s   mul: 8/10, avg 4.7 s   ...

3. V0 Features: timer, timestamp, operation, operands, correct answer, your answer, check mark or x, score,
avg time, categories (mult, sub, add, div), x/y for each category where x is correct and y is total asked (per
category), milliseconds, day streaks
4. What Gets Recorded: correct answers, incorrect answers, time taken, total questions, days practiced, weakest questions with incorrect taking precedence and then time taken being a tie-breaker.

5. Weakest: Lowest accuracy per operation (more time incorrect) with slowest average time breaking ties.

6. Out of Scope for V0: Fancy UI (its a CLI so yk, not much we can do), the hint feature

7. Classes: Operation (enum), Question, QuestionGenerator, QuestionAttempt, GameSession, SessionExporter (interface), CsvExporter, CliRunner (main)

8. Tests: Multiplication bounds (generate 1000 random mult. questions from the generator. for every question, one operand is between 2 and 12 inclusive and the other operand is between 2 and 100 inlusive. verifies that random generation enforces Zetamac's operand ranges in either order). Non-negative subtraction (generate 1,000 random subtraction questions from the generator. For every question, the answer is greater than or equal to 0. Ensures subtraction questions are built by reversing addition so players never have to type negative signs). • Whole-number division (generate 1,000 random division questions from the generator. For every question, the divisor is non-zero and left % right == 0. Guarantees every division problem divides cleanly with no remainder). • Answer checker (create a known question like 7 * 8 and pass both the right answer 56 and a wrong guess 54 into the checker. Assert it returns true for 56 and false for 54. Confirms both validation branches work properly rather than blindly returning true or false). • Per-operation statistics (pass a small hand-computed list of attempts into the stats calculator, such as two ADD attempts taking 1,000 ms and 3,000 ms and one MULTIPLY attempt taking 2,000 ms. Assert ADD reports a count of 2 with a 2,000 ms average and MULTIPLY reports a count of 1 with a 2,000 ms average. Proves grouping by operation accurately isolates counts and averages across different operations).