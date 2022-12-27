---
to: <%= output_path %>/<%= page_name %>.page.tsx
---
import { BasicLayout } from "@/components/layouts/BasicLayout";
import { Meta } from "@/components/meta";
import { Error } from "@/components/templates/Error";
import { Sites } from "@/components/templates/Sites";
import { HttpResponse } from "@/lib/api";
import { auth, combineGssp } from "@/lib/next/gssp";
import { NextPageWithLayout } from "@/lib/next/types";

type Props = HttpResponse<{}>;

const Page: NextPageWithLayout<Props> = ({ err }) =>
  err ? <Error {...err} /> : <Sites />;

Page.getLayout = BasicLayout;
Page.getMeta = Meta();

export const getServerSideProps = combineGssp<Props>(auth(), async () => ({
  /* Use service async function to fetch the data what need. */
  props: { data: {}, err: null, status: 200 },
}));

export default Page;
