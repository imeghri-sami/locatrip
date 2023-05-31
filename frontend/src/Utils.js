export function formatDate(timestamp) {
  const date = new Date(timestamp);

  const options = {
    weekday: "short",
    year: "numeric",
    month: "long",
    day: "numeric",
  };

  return date.toLocaleDateString("en-US", options);
}
