from functools import singledispatchmethod


class Animal:
    @singledispatchmethod
    def bark(self, x):
        raise NotImplementedError

    @bark.register
    def _(self, x: list):
        print("This is list parameterized function", "".join(x))

    @bark.register
    def _(self, x: str):
        print("This is String parameterized function", x)

    
animal = Animal()
animal.bark("[\"d\",'o','g']")