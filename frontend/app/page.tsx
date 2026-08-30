type CatalogApp = {
  id: number;
  name: string;
  description: string;
  category: string;
  version: string;
  icon: string;
};

const fallbackApps: CatalogApp[] = [
  { id: 1, name: "PostgreSQL", description: "Reliable relational database", category: "Database", version: "17.2", icon: "PG" },
  { id: 2, name: "Redis", description: "In-memory cache and message broker", category: "Data", version: "7.4", icon: "RD" },
  { id: 3, name: "Grafana", description: "Dashboards and operational analytics", category: "Observability", version: "11.5", icon: "GF" },
];

async function getApplications(): Promise<{ apps: CatalogApp[]; live: boolean }> {
  try {
    const response = await fetch(`${process.env.NEXT_PUBLIC_API_URL ?? "http://localhost:8080"}/api/applications`, { cache: "no-store" });
    if (!response.ok) throw new Error("API unavailable");
    return { apps: await response.json(), live: true };
  } catch {
    return { apps: fallbackApps, live: false };
  }
}

export default async function Home() {
  const { apps, live } = await getApplications();
  return (
    <main>
      <nav><div className="brand"><span>DH</span> DeployHub</div><div className="status"><i className={live ? "online" : "demo"} />{live ? "API connected" : "Demo data"}</div></nav>
      <section className="hero">
        <p className="eyebrow">GITOPS APPLICATION CATALOG</p>
        <h1>Deploy trusted applications<br /><em>with confidence.</em></h1>
        <p className="intro">A containerized platform demonstrating catalog-driven delivery, continuous integration and cloud-ready architecture.</p>
      </section>
      <section className="catalog">
        <div className="heading"><div><p className="eyebrow">CURATED SOFTWARE</p><h2>Application catalog</h2></div><span>{apps.length} applications</span></div>
        <div className="grid">
          {apps.map((app) => <article key={app.id}><div className="appIcon">{app.icon}</div><div className="pill">{app.category}</div><h3>{app.name}</h3><p>{app.description}</p><footer><span>v{app.version}</span><button>View details <b>→</b></button></footer></article>)}
        </div>
      </section>
    </main>
  );
}

