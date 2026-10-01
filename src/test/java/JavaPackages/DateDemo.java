package JavaPackages;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

    public static void main(String[] args) {

        Date d = new Date();

        System.out.println(d.toString());

        SimpleDateFormat sdf = new SimpleDateFormat("M-dd-yyyy");
        System.out.println(sdf.format(d));

        SimpleDateFormat sdf1 = new SimpleDateFormat("M-dd-yyyy hh:mm:ss");
        System.out.println(sdf1.format(d));
   /*

        ### Interview Explanation

**Interviewer:** Can you explain this code?

                **My answer:**

> "This program demonstrates how to get the current date and time in Java and format it into different date and time patterns.
                >
                > First, I create a `Date` object using `new Date()`. This represents the current date and time based on the system's current time.
                >
                > When I call `d.toString()`, Java prints the date in the default `Date` string format.
>
> Then I use `SimpleDateFormat` to convert the `Date` object into a specific format. For example, `M-dd-yyyy` displays the month, day, and year.
                >
                > Finally, I use `M-dd-yyyy hh:mm:ss` to display both the date and time. Here, `hh` represents the 12-hour clock format and `mm` represents minutes."

### Line-by-line explanation

```java
        Date d = new Date();
```

> "`Date` is a class from `java.util`. When I create this object, it represents the current date and time."

                ---

```java
        System.out.println(d.toString());
```

> "`toString()` converts the `Date` object into a String representation using the default format provided by the `Date` class."

        Example output:

```text
        Tue Sep 29 11:30:25 IST 2026
```

        ---

```java
        SimpleDateFormat sdf = new SimpleDateFormat("M-dd-yyyy");
```

> "`SimpleDateFormat` is used to format a `Date` object according to a pattern.
                >
                > Here:
>
> * `M` = month
                > * `dd` = day
                > * `yyyy` = four-digit year"

        Example:

```text
        9-29-2026
```

        ---

```java
        System.out.println(sdf.format(d));
```

> "`format()` takes the `Date` object and converts it into a String according to the specified pattern."

                ---

```java
        SimpleDateFormat sdf1 =
                new SimpleDateFormat("M-dd-yyyy hh:mm:ss");
```

> "Here I am formatting both the date and time.
                >
                > * `M` = month
                > * `dd` = day
                > * `yyyy` = year
                > * `hh` = hour in 12-hour format
                > * `mm` = minutes
                > * `ss` = seconds"

        Example:

```text
        9-29-2026 11:30:25
```

### Important interview question: `MM` vs `mm`

**Interviewer:** What is the difference between `MM` and `mm`?

**Answer:**

> "`MM` represents the month, while `mm` represents minutes."

```text
                MM = Month
        mm = Minutes
```

        For example:

```java
        "MM-dd-yyyy"
```

        gives:

```text
        09-29-2026
```

        while:

```java
        "MM-dd-yyyy HH:mm:ss"
```

        gives:

```text
        09-29-2026 23:30:25
```

### Important interview question: `HH` vs `hh`

**Interviewer:** What is the difference between `HH` and `hh`?

**Answer:**

> "`HH` represents the hour in 24-hour format, whereas `hh` represents the hour in 12-hour format."

```java
        HH -> 00 to 23
        hh -> 01 to 12
```

        For example:

```java
        "HH:mm:ss"
```

        could produce:

```text
        23:30:25
```

        whereas:

```java
        "hh:mm:ss"
```

        could produce:

```text
        11:30:25
```

        If I use `hh`, I normally use `a` as well when I need AM/PM:

```java
        "MM-dd-yyyy hh:mm:ss a"
```

        Output:

```text
        09-29-2026 11:30:25 PM
```

### 4-Year Experience Interview Question

                **Interviewer:** Is `SimpleDateFormat` the recommended approach in modern Java?

**Answer:**

> "For legacy code, `SimpleDateFormat` is commonly seen. However, in modern Java, I would prefer the `java.time` API such as `LocalDate`, `LocalDateTime`, and `DateTimeFormatter`. The modern API is easier to work with and is thread-safe."

        For example:

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

        public class ModernDateDemo {

            public static void main(String[] args) {

                LocalDateTime currentDateTime = LocalDateTime.now();

                DateTimeFormatter formatter =
                        DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

                String formattedDate = currentDateTime.format(formatter);

                System.out.println(formattedDate);
            }
        }
```

### How I would connect this to Selenium/Automation

                > "In Selenium automation, date formatting is useful when I need to generate dynamic test data, validate dates displayed in the UI, create unique file or report names, or compare application dates with the current system date."

        For example:

```java
        String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        System.out.println(timestamp);
```

        Output:

```text
        20260929_113025
```

        This can be useful for generating unique names such as:

```text
        TestReport_20260929_113025.html
        Screenshot_20260929_113025.png
```

### Short version to remember for the interview

> **"I use `Date` to represent the current date and time, and `SimpleDateFormat` to convert that date into a required String format. The pattern defines how the date and time are displayed. For example, `MM` is month, `dd` is day, `yyyy` is year, `HH` is 24-hour format, `hh` is 12-hour format, `mm` is minutes, and `ss` is seconds. In modern Java, I prefer the `java.time` API and `DateTimeFormatter`."**
*/
    }

}
