/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.jte"],
  theme: {
    extend: {},
  },
  plugins: [
    require('@tailwindcss/forms')
  ],
}
