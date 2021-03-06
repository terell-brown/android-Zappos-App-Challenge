package ca.tbrown.ilovemarshmallow.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ca.tbrown.ilovemarshmallow.R;
import ca.tbrown.ilovemarshmallow.pojo.Result;
import ca.tbrown.ilovemarshmallow.viewholders.ResultViewHolder;


public class ResultAdapter extends RecyclerView.Adapter<ResultViewHolder> {

    private String searchQuery;
    private Context activityContext;
    private List<Result> results;

    public ResultAdapter(List<Result> results) {
        this.results = results;
    }

    public ResultAdapter(Context activityContext, List<Result> results, String query) {
        searchQuery = query;
        this.activityContext = activityContext;
        this.results = results;
        notifyItemRangeChanged(0, results.size());

    }

    @Override
    public ResultViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewholder_result, viewGroup, false);

        return new ResultViewHolder(activityContext,v,searchQuery);
    }

    @Override
    public void onBindViewHolder(ResultViewHolder viewHolder, int i) {
        viewHolder.bind(results.get(i));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
