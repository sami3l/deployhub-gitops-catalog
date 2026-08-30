import type { Metadata } from "next";
import "./globals.css";

export const metadata: Metadata = {
  title: "DeployHub — Application Catalog",
  description: "A GitOps-ready application catalog and DevOps portfolio project.",
};

export default function RootLayout({ children }: Readonly<{ children: React.ReactNode }>) {
  return <html lang="en"><body>{children}</body></html>;
}

