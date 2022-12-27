import { IncomingMessage } from "http";

// 送信元IPの抽出
export const extractRemoteIP = (req: IncomingMessage) => {
  const forwarded = req.headers["x-forwarded-for"];
  return typeof forwarded === "string"
    ? forwarded.split(/, /)[0]
    : req.socket.remoteAddress;
};
