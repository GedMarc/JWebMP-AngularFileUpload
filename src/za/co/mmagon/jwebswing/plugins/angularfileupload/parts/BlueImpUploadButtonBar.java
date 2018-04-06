package za.co.mmagon.jwebswing.plugins.angularfileupload.parts;

import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.html.inputs.InputFileType;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.HTML_TAB;
import static za.co.mmagon.jwebswing.utilities.StaticStrings.STRING_EMPTY;

public class BlueImpUploadButtonBar<J extends BlueImpUploadButtonBar<J>>
		extends DivSimple<J>
{

	private DivSimple<?> buttonBarContainerDiv;

	public BlueImpUploadButtonBar()
	{
		addClass("fileupload-buttonbar");
		buttonBarContainerDiv = new DivSimple<>();
		add(buttonBarContainerDiv);
	}

	@SuppressWarnings("unchecked")
	@NotNull
	public J addAddButton(@Nullable String displayClass, @Nullable String iconClass, @Nullable String label, boolean multiple)
	{
		Span<GlobalChildren, ?, ?> span = new Span();

		if (displayClass != null && !displayClass.isEmpty())
		{
			span.addClass(displayClass);
		}

		span.addClass("fileinput-button");
		span.addAttribute("ng-class", "{disabled: disabled}");

		if (iconClass != null && !iconClass.isEmpty())
		{
			Italic i = new Italic();
			i.addClass(iconClass);
			span.add(i);
		}

		if (label != null && !label.isEmpty())
		{
			Span labelSpan = new Span();
			labelSpan.setText(label);
			span.add(labelSpan);
		}

		InputFileType<?> fileInput = new InputFileType<>();
		fileInput.setName("files[]");
		fileInput.addAttribute("ng-disabled", "disabled");

		if (multiple)
		{
			addAttribute("multiple", STRING_EMPTY);
		}
		span.add(fileInput);

		buttonBarContainerDiv.add(span);
		return (J) this;
	}

	@SuppressWarnings("unchecked")
	@NotNull
	public J addStartButton(@Nullable String displayClass, @Nullable String iconClass, @Nullable String label)
	{
		Button b = new Button<>();
		if (displayClass != null && !displayClass.isEmpty())
		{
			b.addClass(displayClass);
		}
		b.addClass("start");

		b.addAttribute("data-ng-click", "submit()");

		if (iconClass != null && !iconClass.isEmpty())
		{
			Italic i = new Italic();
			i.addClass(iconClass);
			b.add(i);
		}
		if (label != null && !label.isEmpty())
		{
			Span span = new Span();
			span.setText(label);
			b.add(span);
		}
		buttonBarContainerDiv.add(b);

		return (J) this;
	}

	@SuppressWarnings("unchecked")
	@NotNull
	public J addCancelButton(@Nullable String displayClass, @Nullable String iconClass, @Nullable String label)
	{
		Button b = new Button<>();
		if (displayClass != null && !displayClass.isEmpty())
		{
			b.addClass(displayClass);
		}
		b.addClass("cancel");

		b.addAttribute("data-ng-click", "cancel()");

		if (iconClass != null && !iconClass.isEmpty())
		{
			Italic i = new Italic();
			i.addClass(iconClass);
			b.add(i);
		}
		if (label != null && !label.isEmpty())
		{
			Span span = new Span();
			span.setText(label);
			b.add(span);
		}
		buttonBarContainerDiv.add(b);

		return (J) this;
	}

	@NotNull
	@SuppressWarnings("unchecked")
	public J addGlobalFileProcessingState()
	{
		Span sp = new Span();
		sp.addClass("fileupload-process");
		buttonBarContainerDiv.add(sp);
		return (J) this;
	}

	@NotNull
	@SuppressWarnings("unchecked")
	public J addGlobalProgressState(Div divToApplyTo, ComponentHierarchyBase progressBarContainer, ComponentHierarchyBase progressBar)
	{
		divToApplyTo.addAttribute("data-ng-class", "{in: active()}");
		progressBarContainer.addAttribute("data-file-upload-progress", "progress()");
		progressBar.addAttribute("data-ng-style", "{width: num + '%'}");

		divToApplyTo.add(new DivSimple<>().addClass("progress-extended")
		                                  .setText(HTML_TAB));
		return (J) this;
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
}
