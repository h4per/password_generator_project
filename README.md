# Password Generator
‿︵‿ヽ(°□° )ノ︵‿︵
## Description
This is a Java-based password generator that allows users to create strong passwords based on their preferences. The program provides three main options for generating passwords:

1. **Custom Password Generation** – Users can specify password length and character types (uppercase, lowercase, digits, special symbols).
2. **Preset-Based Password Generation** – Users can select from predefined character sets.
3. **Completely Random Password Generation** – A fully randomized password using all available character sets.

Additionally, the program integrates the **zxcvbn** password strength estimator to evaluate the security of generated passwords.

---

## Features
1. Generate passwords with customizable character sets.
2. Use predefined presets for quick password generation.
3. Create completely random passwords.
4. Evaluate password strength with **zxcvbn4j**.

---

## Installation
### Prerequisites:
- Java (JDK 8+)
- [zxcvbn4j (zxcvbn Java Implementation)](https://github.com/nulab/zxcvbn4j)


3. Compile and run the program:
```sh
javac PasswordGenerator.java
java PasswordGenerator
```

---

## Usage
1. Run the program and select an option from the menu.
2. Follow the prompts to customize or select a preset.
3. Receive your generated password along with its security score.

---

## Example Output
```
Hello and welcome! This will help you generate a strong password!(´｡• ᵕ •｡)

Here are our options:
1) Setting the password on your own.
2) Using ready presets.
3) Generate a completely random password!

Choose one of the options: 1

Enter password length: 12
Do you want to include uppercase letters? (y/n): y
Do you want to include lowercase letters? (y/n): y
Do you want to include digits? (y/n): y
Do you want to include special characters? (y/n): y

Password Strength Analysis:
Score: 4 (Very Strong)
Crack time estimate: Centuries

(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
Your generated password is here! --> A@9xL!z4P*2Q
```

---

## License
This project is open-source under the MIT License.

---
