import Tokens from "csrf";

export const tokens = new Tokens();

export const getCsrfTokenToHeader = () => ({
  "Csrf-Token":
    document
      ?.querySelector('meta[name="csrfToken"]')
      ?.getAttribute("content") ?? "",
});
