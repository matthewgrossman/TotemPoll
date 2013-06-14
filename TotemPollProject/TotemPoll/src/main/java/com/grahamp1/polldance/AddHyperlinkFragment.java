package com.grahamp1.polldance;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by demouser on 6/13/13.
 */
public class AddHyperlinkFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View frag_layout = inflater.inflate(R.layout.fragment_add_hyperlink, null);
        final TextView invalidMessage = (TextView) frag_layout.findViewById(R.id.link_invalid_message);
        invalidMessage.setVisibility(View.GONE);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(frag_layout)
                .setPositiveButton("Save",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
//                                invalidMessage.setVisibility(View.GONE);
//
//                                String linkText = ((EditText) view.findViewById(R.id.link_text))
//                                        .getText().toString().trim();
//                                String url = ((EditText) view.findViewById(R.id.link_url))
//                                        .getText().toString().trim();
//
//                                // if URL is valid, create hyperlink
//                                if (URLUtil.isValidUrl(url)) {
//                                    EditText questionText = (EditText) AddHyperlinkFragment.this
//                                            .getActivity().findViewById(R.id.create_question_text);
//                                    questionText.append(Html.fromHtml("<a href=\"" + url + "\">"
//                                            + linkText + "</a>")
//                                    );
//                                    questionText.append(" ");
//                                    questionText.setMovementMethod(LinkMovementMethod.getInstance());
//                                    dialogInterface.cancel();
//                                } else {
//                                    invalidMessage.setVisibility(View.VISIBLE);
//                                }
                            }
                        }
                )
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }
                );

        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String linkText = ((EditText) frag_layout.findViewById(R.id.link_text))
                        .getText().toString().trim();
                String url = ((EditText) frag_layout.findViewById(R.id.link_url))
                        .getText().toString().trim();

                // if URL is valid, create hyperlink
                if (url.equals("") || !URLUtil.isValidUrl(url))
                    invalidMessage.setVisibility(View.VISIBLE);
                else {
                    invalidMessage.setVisibility(View.GONE);

                    if (linkText.equals(""))
                        linkText = url;

                    EditText questionText = (EditText) AddHyperlinkFragment.this
                            .getActivity().findViewById(R.id.create_question_text);
                    questionText.append(Html.fromHtml("<a href=\"" + url + "\">"
                            + linkText + "</a>")
                    );
                    questionText.append(" ");
                    questionText.setMovementMethod(LinkMovementMethod.getInstance());
                    dismiss();
                }
            }
        });

        return dialog;
    }

}
