all:
	@gcc -o chess main.c -Wall -Werror -Wextra

test: all
	@./chess
