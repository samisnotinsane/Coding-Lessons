#include <stdio.h>

int main() {
    printf("Hello, World!\n");

    float a;
    int b;
    char ch;

    printf("Enter value of float\n");
    scanf("%f", &a);

    printf("Enter value of int\n");
    scanf("%d", &b);

    printf("Enter value of char\n");
    scanf(" %c", &ch);

    printf("Value of float : %f", a);
    printf("\nValue of int : %d", b);
    printf("\nValue of char : %c", ch);
    printf("\nValue of float(rounded) : %.2f\n", a);

    return 0;
}