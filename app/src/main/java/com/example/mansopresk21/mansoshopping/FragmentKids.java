package com.example.mansopresk21.mansoshopping;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.example.mansopresk21.mansoshopping.ExpandListView.Child;
import com.example.mansopresk21.mansoshopping.ExpandListView.ExpandListAdapter;
import com.example.mansopresk21.mansoshopping.ExpandListView.Group;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentKids.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentKids#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentKids extends Fragment {
    private ExpandListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;
    ImageView fragmentkidimage;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentKids() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentKids.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentKids newInstance(String param1, String param2) {
        FragmentKids fragment = new FragmentKids();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v2 = inflater.inflate(R.layout.fragment_fragment_kids, container, false);
        fragmentkidimage = (ImageView) v2.findViewById(R.id.fragmentmen_image);
        ExpandList = (ExpandableListView) v2.findViewById(R.id.exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(getContext(), ExpListItems);
        ExpandList.setAdapter(ExpAdapter);


        ExpandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String group_name = ExpListItems.get(groupPosition).getName();

                ArrayList<Child> ch_list = ExpListItems.get(
                        groupPosition).getItems();

                String child_name = ch_list.get(childPosition).getName();



                return false;
            }
        });

        ExpandList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();


            }
        });

        ExpandList.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
            }
        });
        return v2;

    }

    public ArrayList<Group> SetStandardGroups() {

        ArrayList<Group> group_list = new ArrayList<Group>();
        ArrayList<Child> child_list;

        // Setting Group 1

        // Setting Group 2



        child_list = new ArrayList<Child>();
        Group gru3 = new Group();
        gru3.setName("Girls Clothing ");

        Child ch3_1 = new Child();
        ch3_1.setName("Dresses & Skirts");
        child_list.add(ch3_1);

        Child ch3_2 = new Child();
        ch3_2.setName("Jeans & Trousers");
        child_list.add(ch3_2);

        Child ch3_3 = new Child();
        ch3_3.setName("Ethnic Wear");
        child_list.add(ch3_3);

        Child ch3_4 = new Child();
        ch3_4.setName("Tops & T-Shirts");
        child_list.add(ch3_4);

        gru3.setItems(child_list);


        child_list = new ArrayList<Child>();
        Group gru4 = new Group();
        gru4.setName("Boys Clothing ");

        Child ch4_1 = new Child();
        ch4_1.setName("Baby Essentials");
        child_list.add(ch4_1);

        Child ch4_2 = new Child();
        ch4_2.setName("Jeans & Trousers");
        child_list.add(ch4_2);

        Child ch4_3 = new Child();
        ch4_3.setName("Ethnic Wear");
        child_list.add(ch4_3);

        Child ch4_4 = new Child();
        ch4_4.setName("Tops & T-Shirts");
        child_list.add(ch4_4);

        gru4.setItems(child_list);

        //listing all groups


        group_list.add(gru3);
        group_list.add(gru4);

        return group_list;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
