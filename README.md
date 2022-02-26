# Tractive JAVA Test

Backend Developer Task

SKU, Version, Quantity - Coding Task


Write a method that takes two inputs: a list of purchased product codes and a map of mappings for these codes. The method should return an aggregated list of purchased products and quantity based on the list of purchased products codes.

<strong>Inputs</strong>

List of products: ["CVCD", "SDFD", "DDDF", "SDFD"]

Mappings: {"CVCD": {"version": 1,"edition": "X"},"SDFD": {"version": 2,"edition": "Z"},"DDDF": {"version": 1}}

<strong>Expected Output</strong>

Purchased items:
[{"version":1,"edition":"X","quantity":1},{"version":1,"quantity":1},{"version":2,"edition":"Z","qu antity":2}]


##Running the app

```zsh
➜  tractive java Main.java "["CVCD", "SDFD", "DDDF", "SDFD"]" "{"CVCD": {"version": 1,"edition": "X"},"SDFD": {"version": 2,"edition": "Z"},"DDDF": {"version": 1}}"
Purchased items: [{"version": "2,edition": "Z,quantity:2},{"version": "1,edition": "X,quantity:1},{"version": "1,quantity:1}]
```

## JUnit Test

Todo