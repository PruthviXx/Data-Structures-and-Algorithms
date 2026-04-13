const response = await fetch(
  "https://api.freeapi.app/api/v1/public/quotes/random",
  { headers: { accept: "application/json" } },
);

const { data } = await response.json();
console.log(data.quote); // → "The only way to..."
console.log(data.author); // → "Steve Jobs"
