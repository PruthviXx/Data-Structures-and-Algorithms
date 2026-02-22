Stream<int> countStream(int to) async* {
  for (int i = 1; i <= to; i++) {
    yield i; // Yields each number in the sequence
    // await Future.delayed(
    //   Duration(seconds: 2),
    // ); // adds a delay to show the asynchronous nature.
  }
}

void main() async {
  await for (int value in countStream(5)) {
    print(value);
    // await Future.delayed(Duration(seconds: 2));
    print(value * value+1);
  }
}
