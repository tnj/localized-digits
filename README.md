# localized-digits

[![Circle CI](https://circleci.com/gh/tnj/localized-digits.svg?style=svg)](https://circleci.com/gh/tnj/localized-digits)
[![Try it on your device via DeployGate](https://dply.me/eccqpi/button/small)](https://dply.me/eccqpi#install)

## TL;DR

You **must** use `String.format(Locale.US, "%d", 1)` to produce machine-readable
expression of digits in string, otherwise it may produce non-ascii localized
characters in some locales.


## What is this?

This single activity application shows the result of
`String.format("%d", 1234567890)` in available locales on your device.

<img width="320" alt="device-2015-07-31-024722" src="https://cloud.githubusercontent.com/assets/140446/8990725/1901c0b4-372f-11e5-85f6-63df9a2c08f0.png">

That's all, but [you can try it on your device](https://dply.me/eccqpi#install)
if you want.


## Background

Sometimes you face to unexpected behavior on popular standard functions.

```java
String result = String.format("%d", 1);
```

Most people expects `result` is `1`, but in some cases this is not true.
The result depends on *current locale you use*.

This is expected, documented behavior of `java.util.Formatter`.
Each digit expression is generated as offset from zero-digit character
on current locale (for example `0` in en, `٠` in ar, and `၀` in my)
by using `java.text.DecimalFormatSymbols#getZeroDigit()`.
