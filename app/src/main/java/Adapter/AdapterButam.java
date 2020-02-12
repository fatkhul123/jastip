package Adapter;

public class AdapterButam  {


//    private ArrayList<Butam> dataList;
//
//    public AdapterButam(ArrayList<Butam> dataList) {
//        this.dataList = dataList;
//    }
//
//    @Override
//    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View view = layoutInflater.inflate(R.layout.butamlist, parent, false);
//        return new RecyclerViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull AdapterRecycler.RecyclerViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return dataList.size();
//    }
//
//    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
//        private TextView Nama;
//        private Context context;
//
//        public RecyclerViewHolder(View itemView) {
//            super(itemView);
//            context= itemView.getContext();
//            Nama = itemView.findViewById(R.id.list);
//            Nama.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent();
//                    switch (getAdapterPosition()) {
//                        case 0:
//                            intent = new Intent(context, BuTam.class);
//                            break;
//                        case 1:
//                            intent = new Intent(context, BuWati.class);
//                            break;
//                        case 2:
//                            intent = new Intent(context, KantinKoperasi.class);
//                            break;
//                        case 3:
//                            intent = new Intent(context, RusMart.class);
//                            break;
//                        case 4:
//                            intent = new Intent(context, TehPoci.class);
//
//                    }
//                    context.startActivity(intent);
//                }
//            });
//        }
//    }
}