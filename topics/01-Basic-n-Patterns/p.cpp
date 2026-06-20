/*
{
  "version": "2.0.0",
  "tasks": [
    {
      "label": "compile",
      "type": "shell",
      "command": "g++",
      "args": [
        "-std=c++17",
        "-o",
        "${fileDirname}\\${fileBasenameNoExtension}.exe",
        "${file}"
      ],
      "group": {
        "kind": "build",
        "isDefault": false
      },
      "problemMatcher": []
    },
    {
      "label": "compile and run",
      "type": "shell",
      "command": "cmd",
      "args": [
        "/c",
        "g++ -std=c++17 -o \"${fileDirname}\\${fileBasenameNoExtension}.exe\" \"${file}\" && \"${fileDirname}\\${fileBasenameNoExtension}.exe\" < \"${fileDirname}\\input.txt\" > \"${fileDirname}\\output.txt\""
      ],
      "group": {
        "kind": "build",
        "isDefault": true
      },
      "problemMatcher": []
    }
  ]
}

*/
#include <iostream>
using namespace std;

void ppp19(int n)
{
  int space = 0;
  int star = n;
  for (int i = 1; i <= 2 * n - 1; i++)
  {
    for (int j = 1; j <= star; j++)
    {
      cout << "* ";
    }
    for (int m = 1; m <= space; m++)
    {
      cout << "  ";
    }
    for (int k = 1; k <= star; k++)
    {
      cout << "* ";
    }
    cout << endl;
    if (i < n)
    {
      star--;
      space += 2;
    }
    else
    {
      star++;
      space -= 2;
    }
  }
}
long long reverse(int x)
{
  long long r = 0;
  while (x != 0)
  {
    long long l = x % 10;
    r = (r * 10) + l;
    x = x / 10;
  }
  return int(r);
}
int main()
{
  // int n = 5;
  // ppp19(n);
  // cout << reverse(1534236469);

  string s = "MADAM";
  // int size = sizeof(s) / sizeof(s[0]);
  cout << s.length();
  return 0;
}